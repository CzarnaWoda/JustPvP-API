package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.IntEnum;

public class WrapperPlayServerScoreboardDisplayObjective
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.SCOREBOARD_DISPLAY_OBJECTIVE;

public static class Positions
  extends IntEnum
{
  public static final int LIST = 0;
  public static final int SIDEBAR = 1;
  public static final int BELOW_NAME = 2;
  private static final Positions INSTANCE = new Positions();
  
  public static Positions getInstance()
  {
    return INSTANCE;
  }
}

public WrapperPlayServerScoreboardDisplayObjective()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerScoreboardDisplayObjective(PacketContainer packet)
{
  super(packet, TYPE);
}

public byte getPosition()
{
  return ((Integer)this.handle.getIntegers().read(0)).byteValue();
}

public void setPosition(byte value)
{
  this.handle.getIntegers().write(0, Integer.valueOf(value));
}

public String getScoreName()
{
  return (String)this.handle.getStrings().read(0);
}

public void setScoreName(String value)
{
  this.handle.getStrings().write(0, value);
}
}
