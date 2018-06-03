package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.IntEnum;

public class WrapperPlayServerScoreboardObjective
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.SCOREBOARD_OBJECTIVE;

public static class Modes
  extends IntEnum
{
  public static final int ADD_OBJECTIVE = 0;
  public static final int REMOVE_OBJECTIVE = 1;
  public static final int UPDATE_VALUE = 2;
  private static final Modes INSTANCE = new Modes();
  
  public static Modes getInstance()
  {
    return INSTANCE;
  }
}

public WrapperPlayServerScoreboardObjective()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerScoreboardObjective(PacketContainer packet)
{
  super(packet, TYPE);
}

public String getObjectiveName()
{
  return (String)this.handle.getStrings().read(0);
}

public void setObjectiveName(String value)
{
  this.handle.getStrings().write(0, value);
}

public String getObjectiveValue()
{
  return (String)this.handle.getStrings().read(1);
}

public void setObjectiveValue(String value)
{
  this.handle.getStrings().write(1, value);
}

public byte getPacketMode()
{
  return ((Integer)this.handle.getIntegers().read(0)).byteValue();
}

public void setPacketMode(byte value)
{
  this.handle.getIntegers().write(0, Integer.valueOf(value));
}
}
