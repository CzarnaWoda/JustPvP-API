package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayClientLook
extends WrapperPlayClientFlying
{
public static final PacketType TYPE = PacketType.Play.Client.LOOK;

public WrapperPlayClientLook()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayClientLook(PacketContainer packet)
{
  super(packet, TYPE);
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
