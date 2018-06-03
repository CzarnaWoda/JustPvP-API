package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayClientPosition
extends WrapperPlayClientFlying
{
public static final PacketType TYPE = PacketType.Play.Client.POSITION;

public WrapperPlayClientPosition()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayClientPosition(PacketContainer packet)
{
  super(packet, TYPE);
}

public double getX()
{
  return ((Double)this.handle.getDoubles().read(0)).doubleValue();
}

public void setX(double value)
{
  this.handle.getDoubles().write(0, Double.valueOf(value));
}

public double getY()
{
  return ((Double)this.handle.getDoubles().read(1)).doubleValue();
}

public void setY(double value)
{
  this.handle.getDoubles().write(1, Double.valueOf(value));
}

public double getStance()
{
  return ((Double)this.handle.getDoubles().read(3)).doubleValue();
}

public void setStance(double value)
{
  this.handle.getDoubles().write(3, Double.valueOf(value));
}

public double getZ()
{
  return ((Double)this.handle.getDoubles().read(2)).doubleValue();
}

public void setZ(double value)
{
  this.handle.getDoubles().write(2, Double.valueOf(value));
}
}
