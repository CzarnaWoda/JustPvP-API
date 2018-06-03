package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers;

public class WrapperPlayClientClientCommand
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Client.CLIENT_COMMAND;

public WrapperPlayClientClientCommand()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayClientClientCommand(PacketContainer packet)
{
  super(packet, TYPE);
}

public EnumWrappers.ClientCommand getCommand()
{
  return (EnumWrappers.ClientCommand)this.handle.getClientCommands().read(0);
}

public void setCommand(EnumWrappers.ClientCommand value)
{
  this.handle.getClientCommands().write(0, value);
}
}
