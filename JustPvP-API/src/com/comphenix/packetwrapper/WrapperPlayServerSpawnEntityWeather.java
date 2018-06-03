package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerSpawnEntityWeather
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.SPAWN_ENTITY_WEATHER;

public WrapperPlayServerSpawnEntityWeather()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerSpawnEntityWeather(PacketContainer packet)
{
  super(packet, TYPE);
}

public int getEntityId()
{
  return ((Integer)this.handle.getIntegers().read(0)).intValue();
}

public void setEntityId(int value)
{
  this.handle.getIntegers().write(0, Integer.valueOf(value));
}

public byte getType()
{
  return ((Integer)this.handle.getIntegers().read(4)).byteValue();
}

public void setType(byte value)
{
  this.handle.getIntegers().write(4, Integer.valueOf(value));
}

public double getX()
{
  return ((Integer)this.handle.getIntegers().read(1)).intValue() / 32.0D;
}

public void setX(double value)
{
  this.handle.getIntegers().write(1, Integer.valueOf((int)(value * 32.0D)));
}

public double getY()
{
  return ((Integer)this.handle.getIntegers().read(2)).intValue() / 32.0D;
}

public void setY(double value)
{
  this.handle.getIntegers().write(2, Integer.valueOf((int)(value * 32.0D)));
}

public double getZ()
{
  return ((Integer)this.handle.getIntegers().read(3)).intValue() / 32.0D;
}

public void setZ(double value)
{
  this.handle.getIntegers().write(3, Integer.valueOf((int)(value * 32.0D)));
}
}

