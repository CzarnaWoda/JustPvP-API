package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers;

public class WrapperPlayClientSettings
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Client.SETTINGS;

public WrapperPlayClientSettings()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayClientSettings(PacketContainer packet)
{
  super(packet, TYPE);
}

public String getLocale()
{
  return (String)this.handle.getStrings().read(0);
}

public void setLocale(String value)
{
  this.handle.getStrings().write(0, value);
}

public byte getViewDistance()
{
  return ((Integer)this.handle.getIntegers().read(0)).byteValue();
}

public void setViewDistance(byte value)
{
  this.handle.getIntegers().write(0, Integer.valueOf(value));
}

public EnumWrappers.ChatVisibility getChatVisibility()
{
  return (EnumWrappers.ChatVisibility)this.handle.getChatVisibilities().read(0);
}

public void setChatFlags(EnumWrappers.ChatVisibility value)
{
  this.handle.getChatVisibilities().write(0, value);
}

public boolean getChatColours()
{
  return ((Boolean)this.handle.getSpecificModifier(Boolean.TYPE).read(0)).booleanValue();
}

public void setChatColours(boolean value)
{
  this.handle.getSpecificModifier(Boolean.TYPE).write(0, Boolean.valueOf(value));
}

public EnumWrappers.Difficulty getDifficulty()
{
  return (EnumWrappers.Difficulty)this.handle.getDifficulties().read(0);
}

public void setDifficulty(EnumWrappers.Difficulty difficulty)
{
  this.handle.getDifficulties().write(0, difficulty);
}

public boolean getShowCape()
{
  return ((Boolean)this.handle.getSpecificModifier(Boolean.TYPE).read(1)).booleanValue();
}

public void setShowCape(boolean value)
{
  this.handle.getSpecificModifier(Boolean.TYPE).write(1, Boolean.valueOf(value));
}
}
