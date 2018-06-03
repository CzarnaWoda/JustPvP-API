package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerUpdateTime
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.UPDATE_TIME;

public WrapperPlayServerUpdateTime()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerUpdateTime(PacketContainer packet)
{
  super(packet, TYPE);
}

public long getAgeOfTheWorld()
{
  return ((Long)this.handle.getLongs().read(0)).longValue();
}

public void setAgeOfTheWorld(long value)
{
  this.handle.getLongs().write(0, Long.valueOf(value));
}

public long getTimeOfDay()
{
  return ((Long)this.handle.getLongs().read(1)).longValue();
}

public void setTimeOfDay(long value)
{
  this.handle.getLongs().write(1, Long.valueOf(value));
}
}
