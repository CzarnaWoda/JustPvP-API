package com.comphenix.packetwrapper;

import java.util.Map;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedStatistic;

public class WrapperPlayServerStatistics
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.STATISTICS;

public WrapperPlayServerStatistics()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerStatistics(PacketContainer packet)
{
  super(packet, TYPE);
}

@SuppressWarnings({ "unchecked", "rawtypes" })
public Map<WrappedStatistic, Integer> getStatistics()
{
  return (Map)this.handle.getStatisticMaps().read(0);
}

public void setStatistics(Map<WrappedStatistic, Integer> changes)
{
  this.handle.getStatisticMaps().write(0, changes);
}
}
