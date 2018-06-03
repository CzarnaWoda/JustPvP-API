package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerTabComplete
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.TAB_COMPLETE;

public WrapperPlayServerTabComplete()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public String[] getText()
{
  return (String[])this.handle.getStringArrays().read(0);
}

public void setText(String[] value)
{
  this.handle.getStringArrays().write(0, value);
}
}
