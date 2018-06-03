package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperStatusClientInPing
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Status.Client.IN_PING;

public WrapperStatusClientInPing()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperStatusClientInPing(PacketContainer packet)
{
  super(packet, TYPE);
}

public long getToken()
{
  return ((Long)this.handle.getLongs().read(0)).longValue();
}

public void setToken(long value)
{
  this.handle.getLongs().write(0, Long.valueOf(value));
}
}
