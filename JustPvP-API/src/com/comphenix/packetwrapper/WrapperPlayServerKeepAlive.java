package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerKeepAlive
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.KEEP_ALIVE;

public WrapperPlayServerKeepAlive()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerKeepAlive(PacketContainer packet)
{
  super(packet, TYPE);
}

public int getKeepAliveId()
{
  return ((Integer)this.handle.getIntegers().read(0)).intValue();
}

public void setKeepAliveId(int value)
{
  this.handle.getIntegers().write(0, Integer.valueOf(value));
}
}
