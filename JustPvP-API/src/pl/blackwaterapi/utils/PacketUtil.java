package pl.blackwaterapi.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

import org.bukkit.entity.Player;

import com.google.common.base.Charsets;
import com.mojang.authlib.GameProfile;

public class PacketUtil
{
  public static void sendPacket(Player player, Object... objects)
  {
    Object handle = getHandle(player);
    for (Object o : objects) {
      sendPacket.invoke(playerConnection.get(handle), new Object[] { o });
    }
  }
  
  public static int getPing(Player p)
  {
    return ((Integer)ping.get(entityHandleMethod.invoke(p, new Object[0]))).intValue();
  }
  
  public static Object getHandle(Player p)
  {
    if (entityHandleMethod == null) {
      throw new IllegalArgumentException("HandleMethod can not be null!");
    }
    return entityHandleMethod.invoke(p, new Object[0]);
  }
  
  public static GameProfile getGameProfile(String name)
  {
    return new GameProfile(UUID.nameUUIDFromBytes(("OfflinePlayer:" + name).getBytes(Charsets.UTF_8)), name);
  }
  
  private static Reflection.MethodInvoker entityHandleMethod = null;
  private static Reflection.MethodInvoker sendPacket = null;
  private static Reflection.FieldAccessor<Object> playerConnection = null;
  
  static
  {
    entityHandleMethod = Reflection.getMethod(Reflection.getCraftBukkitClass("entity.CraftEntity"), "getHandle", (Class[])new Class[0]);
    sendPacket = Reflection.getMethod(Reflection.getMinecraftClass("PlayerConnection"), "sendPacket", new Class[] { Reflection.getMinecraftClass("Packet") });
    playerConnection = Reflection.getSimpleField(Reflection.getMinecraftClass("EntityPlayer"), "playerConnection");
  }
  
  @SuppressWarnings("unused")
private static Reflection.FieldAccessor<Object> networkManager = Reflection.getSimpleField(Reflection.getMinecraftClass("PlayerConnection"), "networkManager");
  private static Reflection.FieldAccessor<Integer> ping = Reflection.getField(Reflection.getMinecraftClass("EntityPlayer"), "ping", Integer.TYPE);
  
  @SuppressWarnings("unused")
private static class PACKET1S
  {
    public static Object createTeamPacket(String name, String display, String prefix, String suffix, int flag, String... members)
    {
      Object packet = con.invoke(new Object[0]);
      a.set(packet, name.length() > 16 ? name.substring(0, 16) : name);
      f.set(packet, Integer.valueOf(flag));
      if ((flag == 0) || (flag == 2))
      {
        b.set(packet, display == null ? "" : display.substring(0, Math.min(display.length(), 16)));
        c.set(packet, prefix == null ? "" : prefix.substring(0, Math.min(prefix.length(), 16)));
        d.set(packet, suffix == null ? "" : suffix.substring(0, Math.min(suffix.length(), 16)));
        g.set(packet, Integer.valueOf(0));
        if (flag == 0) {
          e.set(packet, Arrays.asList(members));
        }
      }
      else if ((flag == 3) || (flag == 4))
      {
        g.set(packet, Integer.valueOf(0));
        e.set(packet, Arrays.asList(members));
      }
      return packet;
    }
    
    public static Object createPlayerPacket(String name, boolean visible, int ping)
    {
      return conPlayer.invoke(new Object[] { name, Boolean.valueOf(visible), Integer.valueOf(ping) });
    }
    
    private static Class<?> packetClass = Reflection.getMinecraftClass("PacketPlayOutScoreboardTeam");
    private static Class<?> packetClassPlayer = Reflection.getMinecraftClass("PacketPlayOutPlayerInfo");
    private static Reflection.ConstructorInvoker con = Reflection.getConstructor(packetClass, (Class[])new Class[0]);
    private static Reflection.ConstructorInvoker conPlayer = Reflection.getConstructor(packetClassPlayer, new Class[] { String.class, Boolean.TYPE, Integer.TYPE });
    private static Reflection.FieldAccessor<String> a = Reflection.getField(packetClass, "a", String.class);
    private static Reflection.FieldAccessor<String> b = Reflection.getField(packetClass, "b", String.class);
    private static Reflection.FieldAccessor<String> c = Reflection.getField(packetClass, "c", String.class);
    private static Reflection.FieldAccessor<String> d = Reflection.getField(packetClass, "d", String.class);
    @SuppressWarnings("rawtypes")
	private static Reflection.FieldAccessor<Collection> e = Reflection.getField(packetClass, "e", Collection.class);
    private static Reflection.FieldAccessor<Integer> f = Reflection.getField(packetClass, "f", Integer.TYPE);
    private static Reflection.FieldAccessor<Integer> g = Reflection.getField(packetClass, "g", Integer.TYPE);
  }
}
