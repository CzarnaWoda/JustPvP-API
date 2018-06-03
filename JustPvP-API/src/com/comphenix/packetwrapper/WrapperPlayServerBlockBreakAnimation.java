package com.comphenix.packetwrapper;

import org.bukkit.World;
import org.bukkit.entity.Entity;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

public class WrapperPlayServerBlockBreakAnimation
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.BLOCK_BREAK_ANIMATION;

public WrapperPlayServerBlockBreakAnimation()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerBlockBreakAnimation(PacketContainer packet)
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

public int getX()
{
  return ((Integer)this.handle.getIntegers().read(1)).intValue();
}

public void setX(int value)
{
  this.handle.getIntegers().write(1, Integer.valueOf(value));
}

public int getY()
{
  return ((Integer)this.handle.getIntegers().read(2)).intValue();
}

public void setY(int value)
{
  this.handle.getIntegers().write(2, Integer.valueOf(value));
}

public int getZ()
{
  return ((Integer)this.handle.getIntegers().read(3)).intValue();
}

public void setZ(int value)
{
  this.handle.getIntegers().write(3, Integer.valueOf(value));
}

public byte getDestroyStage()
{
  return ((Integer)this.handle.getIntegers().read(4)).byteValue();
}

public void setDestroyStage(byte value)
{
  this.handle.getIntegers().write(4, Integer.valueOf(value));
}
}

