package com.comphenix.packetwrapper;

import javax.annotation.Nonnull;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerMap
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.MAP;

public WrapperPlayServerMap()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerMap(PacketContainer packet)
{
  super(packet, TYPE);
}

public int getItemDamage()
{
  return ((Integer)this.handle.getIntegers().read(0)).intValue();
}

public void setItemDamage(int value)
{
  this.handle.getIntegers().write(0, Integer.valueOf(value));
}

public byte[] getData()
{
  return (byte[])this.handle.getByteArrays().read(0);
}

public void setData(@Nonnull byte[] value)
{
  if (value == null) {
    throw new IllegalArgumentException("Array cannot be NULL.");
  }
  this.handle.getByteArrays().write(0, value);
}
}
