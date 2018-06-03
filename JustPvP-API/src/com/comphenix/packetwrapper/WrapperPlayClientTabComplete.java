package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayClientTabComplete
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Client.TAB_COMPLETE;

public WrapperPlayClientTabComplete()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayClientTabComplete(PacketContainer packet)
{
  super(packet, TYPE);
}

public String getText()
{
  return (String)this.handle.getStrings().read(0);
}

public void setText(String value)
{
  this.handle.getStrings().write(0, value);
}
}
