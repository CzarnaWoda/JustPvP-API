package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedChatComponent;

public class WrapperLoginServerDisconnect
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Login.Server.DISCONNECT;

public WrapperLoginServerDisconnect()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperLoginServerDisconnect(PacketContainer packet)
{
  super(packet, TYPE);
}

public WrappedChatComponent getJsonData()
{
  return (WrappedChatComponent)this.handle.getChatComponents().read(0);
}

public void setJsonData(WrappedChatComponent value)
{
  this.handle.getChatComponents().write(0, value);
}
}
