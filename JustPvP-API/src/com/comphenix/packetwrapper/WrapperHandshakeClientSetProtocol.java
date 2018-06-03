package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperHandshakeClientSetProtocol
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Handshake.Client.SET_PROTOCOL;

public WrapperHandshakeClientSetProtocol()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperHandshakeClientSetProtocol(PacketContainer packet)
{
  super(packet, TYPE);
}

public int getProtocolVersion()
{
  return ((Integer)this.handle.getIntegers().read(0)).intValue();
}

public void setProtocolVersion(int value)
{
  this.handle.getIntegers().write(0, Integer.valueOf(value));
}

public String getServerHostname()
{
  return (String)this.handle.getStrings().read(0);
}

public void setServerHostname(String value)
{
  this.handle.getStrings().write(0, value);
}

public short getServerPort()
{
  return ((Integer)this.handle.getIntegers().read(1)).shortValue();
}

public void setServerPort(short value)
{
  this.handle.getIntegers().write(1, Integer.valueOf(value));
}

public PacketType.Protocol getNextProtocol()
{
  return (PacketType.Protocol)this.handle.getProtocols().read(0);
}

public void setNextProtocol(PacketType.Protocol value)
{
  this.handle.getProtocols().write(0, value);
}
}