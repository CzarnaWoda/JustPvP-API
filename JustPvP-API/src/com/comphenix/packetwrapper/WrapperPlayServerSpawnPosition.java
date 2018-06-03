package com.comphenix.packetwrapper;

import org.bukkit.util.Vector;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerSpawnPosition
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.SPAWN_POSITION;

public WrapperPlayServerSpawnPosition()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerSpawnPosition(PacketContainer packet)
{
  super(packet, TYPE);
}

public int getX()
{
  return ((Integer)this.handle.getIntegers().read(0)).intValue();
}

public void setX(int value)
{
  this.handle.getIntegers().write(0, Integer.valueOf(value));
}

public int getY()
{
  return ((Integer)this.handle.getIntegers().read(1)).intValue();
}

public void setY(int value)
{
  this.handle.getIntegers().write(1, Integer.valueOf(value));
}

public int getZ()
{
  return ((Integer)this.handle.getIntegers().read(2)).intValue();
}

public void setZ(int value)
{
  this.handle.getIntegers().write(2, Integer.valueOf(value));
}

public void setLocation(Vector point)
{
  setX(point.getBlockX());
  setY(point.getBlockY());
  setZ(point.getBlockZ());
}

public Vector getLocation()
{
  return new Vector(getX(), getY(), getZ());
}
}

