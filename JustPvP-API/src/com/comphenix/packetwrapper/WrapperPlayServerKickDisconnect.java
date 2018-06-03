package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedChatComponent;

public class WrapperPlayServerKickDisconnect
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.KICK_DISCONNECT;

public WrapperPlayServerKickDisconnect()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerKickDisconnect(PacketContainer packet)
{
  super(packet, TYPE);
}

public WrappedChatComponent getReason()
{
  return (WrappedChatComponent)this.handle.getChatComponents().read(0);
}

public void setReason(WrappedChatComponent value)
{
  this.handle.getChatComponents().write(0, value);
}
}
