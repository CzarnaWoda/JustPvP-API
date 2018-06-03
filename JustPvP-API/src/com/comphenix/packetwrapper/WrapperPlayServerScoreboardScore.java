package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.IntEnum;

public class WrapperPlayServerScoreboardScore
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.SCOREBOARD_SCORE;

public static class Modes
  extends IntEnum
{
  public static final int SET_SCORE = 0;
  public static final int REMOVE_SCORE = 1;
  private static final Modes INSTANCE = new Modes();
  
  public static Modes getInstance()
  {
    return INSTANCE;
  }
}

public WrapperPlayServerScoreboardScore()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerScoreboardScore(PacketContainer packet)
{
  super(packet, TYPE);
}

public String getItemName()
{
  return (String)this.handle.getStrings().read(0);
}

public void setItemName(String value)
{
  this.handle.getStrings().write(0, value);
}

public byte getPacketMode()
{
  return ((Integer)this.handle.getIntegers().read(1)).byteValue();
}

public void setPacketMode(byte value)
{
  this.handle.getIntegers().write(1, Integer.valueOf(value));
}

public String getScoreName()
{
  return (String)this.handle.getStrings().read(1);
}

public void setScoreName(String value)
{
  this.handle.getStrings().write(1, value);
}

public int getValue()
{
  return ((Integer)this.handle.getIntegers().read(0)).intValue();
}

public void setValue(int value)
{
  this.handle.getIntegers().write(0, Integer.valueOf(value));
}
}

