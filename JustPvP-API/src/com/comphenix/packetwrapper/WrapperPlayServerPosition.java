package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerPosition
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.POSITION;

public WrapperPlayServerPosition()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerPosition(PacketContainer packet)
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

public boolean getOnGround()
{
  return ((Boolean)this.handle.getSpecificModifier(Boolean.TYPE).read(0)).booleanValue();
}

public void setOnGround(boolean value)
{
  this.handle.getSpecificModifier(Boolean.TYPE).write(0, Boolean.valueOf(value));
}
}
