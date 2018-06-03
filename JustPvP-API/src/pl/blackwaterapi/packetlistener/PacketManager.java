package pl.blackwaterapi.packetlistener;

import java.nio.channels.Channel;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import pl.blackwaterapi.utils.Reflection;
import pl.blackwaterapi.utils.packets.PacketReceiveEvent;
import pl.blackwaterapi.utils.packets.PacketSendEvent;



public class PacketManager
{
  private static Channel getChannel(Player p)
  {
    Object eP = handleMethod.invoke(p, new Object[0]);
    return (Channel)clientChannel.get(networkManager.get(playerConnection.get(eP)));
  }
  
  public static void registerPlayer(Player p)
  {
    Channel c = getChannel(p);
    ChannelHandler handler = new ChannelDuplexHandler()
    {
      public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise)
        throws Exception
      {
        PacketSendEvent event = new PacketSendEvent(msg, p);
        Bukkit.getPluginManager().callEvent(event);
        if ((event.isCancelled()) || (event.getPacket() == null)) {
          return;
        }
        super.write(ctx, event.getPacket(), promise);
      }
      
      public void channelRead(ChannelHandlerContext ctx, Object msg)
        throws Exception
      {
        PacketReceiveEvent event = new PacketReceiveEvent(msg, p);
        Bukkit.getPluginManager().callEvent(event);
        if ((event.isCancelled()) || (event.getPacket() == null)) {
          return;
        }
        super.channelRead(ctx, event.getPacket());
      }
    };
    ((ChannelHandlerContext) c).pipeline().addBefore("packet_handler", "ChestPvP-Api", handler);
    channels.put(p.getUniqueId(), c);
  }
  
  public static void unregisterPlayer(Player p)
  {
    ((ChannelHandlerContext)channels.remove(p.getUniqueId())).pipeline().remove("ChestPvP-Api");
  }
  
  public static HashMap<UUID, Channel> getChannels()
  {
    return channels;
  }
  
  @SuppressWarnings({ "rawtypes", "unchecked" })
private static HashMap<UUID, Channel> channels = new HashMap();
  private static Reflection.FieldAccessor<Channel> clientChannel;
  private static Reflection.FieldAccessor<Object> playerConnection;
  private static Reflection.FieldAccessor<Object> networkManager;
  private static Reflection.MethodInvoker handleMethod;
  
  static
  {
    try
    {
      clientChannel = Reflection.getField(Reflection.getMinecraftClass("NetworkManager"), Channel.class, 0);
      playerConnection = Reflection.getSimpleField(Reflection.getMinecraftClass("EntityPlayer"), "playerConnection");
      networkManager = Reflection.getSimpleField(Reflection.getMinecraftClass("PlayerConnection"), "networkManager");
      handleMethod = Reflection.getMethod(Reflection.getCraftBukkitClass("entity.CraftEntity"), "getHandle", (Class[])new Class[0]);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
