package com.comphenix.packetwrapper;

import org.bukkit.World;
import org.bukkit.entity.Entity;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

public class WrapperPlayServerEntityTeleport
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.ENTITY_TELEPORT;

public WrapperPlayServerEntityTeleport()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerEntityTeleport(PacketContainer packet)
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

public double getX()
{
  return ((Integer)this.handle.getIntegers().read(1)).intValue() / 32.0D;
}

public void setX(double value)
{
  this.handle.getIntegers().write(1, Integer.valueOf((int)Math.floor(value * 32.0D)));
}

public double getY()
{
  return ((Integer)this.handle.getIntegers().read(2)).intValue() / 32.0D;
}

public void setY(double value)
{
  this.handle.getIntegers().write(2, Integer.valueOf((int)Math.floor(value * 32.0D)));
}

public double getZ()
{
  return ((Integer)this.handle.getIntegers().read(3)).intValue() / 32.0D;
}

public void setZ(double value)
{
  this.handle.getIntegers().write(3, Integer.valueOf((int)Math.floor(value * 32.0D)));
}

public float getYaw()
{
  return ((Byte)this.handle.getBytes().read(0)).byteValue() * 360.0F / 256.0F;
}

public void setYaw(float value)
{
  this.handle.getBytes().write(0, Byte.valueOf((byte)(int)(value * 256.0F / 360.0F)));
}

public float getPitch()
{
  return ((Byte)this.handle.getBytes().read(1)).byteValue() * 360.0F / 256.0F;
}

public void setPitch(float value)
{
  this.handle.getBytes().write(1, Byte.valueOf((byte)(int)(value * 256.0F / 360.0F)));
}
}