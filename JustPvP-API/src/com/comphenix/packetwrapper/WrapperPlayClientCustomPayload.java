package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayClientCustomPayload
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Client.CUSTOM_PAYLOAD;

public WrapperPlayClientCustomPayload()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayClientCustomPayload(PacketContainer packet)
{
  super(packet, TYPE);
}

public String getChannel()
{
  return (String)this.handle.getStrings().read(0);
}

public void setChannel(String value)
{
  this.handle.getStrings().write(0, value);
}

public short getLength()
{
  return ((Integer)this.handle.getIntegers().read(0)).shortValue();
}

public void setLength(short value)
{
  this.handle.getIntegers().write(0, Integer.valueOf(value));
}

public byte[] getData()
{
  return (byte[])this.handle.getByteArrays().read(0);
}

public void setData(byte[] value)
{
  setLength((short)value.length);
  this.handle.getByteArrays().write(0, value);
}
}
