package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerExperience
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.EXPERIENCE;

public WrapperPlayServerExperience()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerExperience(PacketContainer packet)
{
  super(packet, TYPE);
}

public float getExperienceBar()
{
  return ((Float)this.handle.getFloat().read(0)).floatValue();
}

public void setExperienceBar(float value)
{
  this.handle.getFloat().write(0, Float.valueOf(value));
}

public short getLevel()
{
  return ((Integer)this.handle.getIntegers().read(1)).shortValue();
}

public void setLevel(short value)
{
  this.handle.getIntegers().write(1, Integer.valueOf(value));
}

public short getTotalExperience()
{
  return ((Integer)this.handle.getIntegers().read(0)).shortValue();
}

public void setTotalExperience(short value)
{
  this.handle.getIntegers().write(0, Integer.valueOf(value));
}
}
