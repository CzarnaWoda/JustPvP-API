package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerPlayerInfo
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.PLAYER_INFO;

public WrapperPlayServerPlayerInfo()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerPlayerInfo(PacketContainer packet)
{
  super(packet, TYPE);
}

public String getPlayerName()
{
  return (String)this.handle.getStrings().read(0);
}

public void setPlayerName(String value)
{
  this.handle.getStrings().write(0, value);
}

public boolean getOnline()
{
  return ((Boolean)this.handle.getSpecificModifier(Boolean.TYPE).read(0)).booleanValue();
}

public void setOnline(boolean value)
{
  this.handle.getSpecificModifier(Boolean.TYPE).write(0, Boolean.valueOf(value));
}

public short getPing()
{
  return ((Integer)this.handle.getIntegers().read(0)).shortValue();
}

public void setPing(short value)
{
  this.handle.getIntegers().write(0, Integer.valueOf(value));
}
}
