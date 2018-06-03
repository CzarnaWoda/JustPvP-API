package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerCustomPayload
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.CUSTOM_PAYLOAD;

public WrapperPlayServerCustomPayload()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerCustomPayload(PacketContainer packet)
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

public byte[] getData()
{
  return (byte[])this.handle.getByteArrays().read(0);
}

public void setData(byte[] value)
{
  this.handle.getByteArrays().write(0, value);
}
}
