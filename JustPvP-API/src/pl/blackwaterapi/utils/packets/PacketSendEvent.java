package pl.blackwaterapi.utils.packets;


import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PacketSendEvent
  extends Event
  implements Cancellable
{
  public PacketSendEvent(Object packet, Player player)
  {
    super(true);
    this.packet = packet;
    this.player = player;
    this.cancelled = false;
  }
  
  public static HandlerList getHandlerList()
  {
    return handlers;
  }
  
  public String getPacketName()
  {
    return this.packet.getClass().getSimpleName();
  }
  
  public HandlerList getHandlers()
  {
    return handlers;
  }
  
  public Player getPlayer()
  {
    return this.player;
  }
  
  public Object getPacket()
  {
    return this.packet;
  }
  
  public boolean isCancelled()
  {
    return this.cancelled;
  }
  
  public void setPacket(Object packet)
  {
    this.packet = packet;
  }
  
  public void setCancelled(boolean cancelled)
  {
    this.cancelled = cancelled;
  }
  
  private static HandlerList handlers = new HandlerList();
  private Player player;
  private Object packet;
  private boolean cancelled;
}
