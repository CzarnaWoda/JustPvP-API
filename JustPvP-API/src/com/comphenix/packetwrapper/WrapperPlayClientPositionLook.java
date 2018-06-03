package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayClientPositionLook
extends WrapperPlayClientFlying
{
public static final PacketType TYPE = PacketType.Play.Client.POSITION_LOOK;

public WrapperPlayClientPositionLook()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayClientPositionLook(PacketContainer packet)
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

public float getYaw()
{
  return ((Float)this.handle.getFloat().read(0)).floatValue();
}

public void setYaw(float value)
{
  this.handle.getFloat().write(0, Float.valueOf(value));
}

public float getPitch()
{
  return ((Float)this.handle.getFloat().read(1)).floatValue();
}

public void setPitch(float value)
{
  this.handle.getFloat().write(1, Float.valueOf(value));
}
}

