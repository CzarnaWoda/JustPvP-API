package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerEntityLook
extends WrapperPlayServerEntity
{
public static final PacketType TYPE = PacketType.Play.Server.ENTITY_LOOK;

public WrapperPlayServerEntityLook()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerEntityLook(PacketContainer packet)
{
  super(packet, TYPE);
}

public float getYaw()
{
  return ((Byte)this.handle.getBytes().read(3)).byteValue() * 360.0F / 256.0F;
}

public void setYaw(float value)
{
  this.handle.getBytes().write(3, Byte.valueOf((byte)(int)(value * 256.0F / 360.0F)));
}

public float getPitch()
{
  return ((Byte)this.handle.getBytes().read(4)).byteValue() * 360.0F / 256.0F;
}

public void setPitch(float value)
{
  this.handle.getBytes().write(4, Byte.valueOf((byte)(int)(value * 256.0F / 360.0F)));
}
}
