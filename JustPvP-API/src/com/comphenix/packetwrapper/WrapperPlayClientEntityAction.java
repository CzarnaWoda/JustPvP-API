package com.comphenix.packetwrapper;

import org.bukkit.World;
import org.bukkit.entity.Entity;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.reflect.IntEnum;

public class WrapperPlayClientEntityAction
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Client.ENTITY_ACTION;

public static class Action
  extends IntEnum
{
  public static final int CROUCH = 1;
  public static final int UNCROUCH = 2;
  public static final int LEAVE_BED = 3;
  public static final int START_SPRINTING = 4;
  public static final int STOP_SPRINTING = 5;
  private static final Action INSTANCE = new Action();
  
  public static Action getInstance()
  {
    return INSTANCE;
  }
}

public WrapperPlayClientEntityAction()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayClientEntityAction(PacketContainer packet)
{
  super(packet, TYPE);
}

public int getEntityID()
{
  return ((Integer)this.handle.getIntegers().read(0)).intValue();
}

public void setEntityID(int value)
{
  this.handle.getIntegers().write(0, Integer.valueOf(value));
}

public Entity getEntity(World world)
{
  return (Entity)this.handle.getEntityModifier(world).read(0);
}

public Entity getEntity(PacketEvent event)
{
  return getEntity(event.getPlayer().getWorld());
}

public byte getActionId()
{
  return ((Integer)this.handle.getIntegers().read(1)).byteValue();
}

public void setActionId(byte value)
{
  this.handle.getIntegers().write(1, Integer.valueOf(value));
}

public int getJumpBoost()
{
  return ((Integer)this.handle.getIntegers().read(2)).intValue();
}

public void setJumpBoost(int value)
{
  this.handle.getIntegers().write(2, Integer.valueOf(value));
}
}
