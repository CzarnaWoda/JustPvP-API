package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayClientKeepAlive
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Client.KEEP_ALIVE;

public WrapperPlayClientKeepAlive()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayClientKeepAlive(PacketContainer packet)
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
