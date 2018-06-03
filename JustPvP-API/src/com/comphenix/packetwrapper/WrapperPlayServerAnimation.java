package com.comphenix.packetwrapper;

import org.bukkit.World;
import org.bukkit.entity.Entity;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.reflect.IntEnum;

public class WrapperPlayServerAnimation
extends AbstractPacket
{
public static class Animations
  extends IntEnum
{
  public static final int SWING_ARM = 0;
  public static final int DAMAGE_ANIMATION = 1;
  public static final int LEAVE_BED = 2;
  public static final int EAT_FOOD = 3;
  public static final int CRITICAL_EFFECT = 4;
  public static final int MAGIC_CRITICAL_EFFECT = 5;
  public static final int UNKNOWN = 102;
  public static final int CROUCH = 104;
  public static final int UNCROUCH = 105;
  private static Animations INSTANCE = new Animations();
  
  public static Animations getInstance()
  {
    return INSTANCE;
  }
}

public static final PacketType TYPE = PacketType.Play.Server.ANIMATION;

public WrapperPlayServerAnimation()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerAnimation(PacketContainer packet)
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

public int getAnimation()
{
  return ((Integer)this.handle.getIntegers().read(1)).intValue();
}

public void setAnimation(int value)
{
  this.handle.getIntegers().write(1, Integer.valueOf(value));
}
}
