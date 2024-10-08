package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedServerPing;

public class WrapperStatusServerOutServerInfo
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Status.Server.OUT_SERVER_INFO;

public WrapperStatusServerOutServerInfo()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperStatusServerOutServerInfo(PacketContainer packet)
{
  super(packet, TYPE);
}

public WrappedServerPing getServerPing()
{
  return (WrappedServerPing)this.handle.getServerPings().read(0);
}

public void setServerPing(WrappedServerPing value)
{
  this.handle.getServerPings().write(0, value);
}
}
