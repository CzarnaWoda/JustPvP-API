package com.comphenix.packetwrapper;

import java.util.Collection;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.IntEnum;

public class WrapperPlayServerScoreboardTeam
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.SCOREBOARD_TEAM;

public static class Modes
  extends IntEnum
{
  public static final int TEAM_CREATED = 0;
  public static final int TEAM_REMOVED = 1;
  public static final int TEAM_UPDATED = 2;
  public static final int PLAYERS_ADDED = 3;
  public static final int PLAYERS_REMOVED = 4;
  private static final Modes INSTANCE = new Modes();
  
  public static Modes getInstance()
  {
    return INSTANCE;
  }
}

public WrapperPlayServerScoreboardTeam()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerScoreboardTeam(PacketContainer packet)
{
  super(packet, TYPE);
}

public String getTeamName()
{
  return (String)this.handle.getStrings().read(0);
}

public void setTeamName(String value)
{
  this.handle.getStrings().write(0, value);
}

public byte getPacketMode()
{
  return ((Integer)this.handle.getIntegers().read(0)).byteValue();
}

public void setPacketMode(byte value)
{
  this.handle.getIntegers().write(0, Integer.valueOf(value));
}

public String getTeamDisplayName()
{
  return (String)this.handle.getStrings().read(1);
}

public void setTeamDisplayName(String value)
{
  this.handle.getStrings().write(1, value);
}

public String getTeamPrefix()
{
  return (String)this.handle.getStrings().read(2);
}

public void setTeamPrefix(String value)
{
  this.handle.getStrings().write(2, value);
}

public String getTeamSuffix()
{
  return (String)this.handle.getStrings().read(3);
}

public void setTeamSuffix(String value)
{
  this.handle.getStrings().write(3, value);
}

public byte getFriendlyFire()
{
  return ((Integer)this.handle.getIntegers().read(1)).byteValue();
}

public void setFriendlyFire(byte value)
{
  this.handle.getIntegers().write(1, Integer.valueOf(value));
}
@SuppressWarnings({ "unchecked", "rawtypes" })
public Collection<String> getPlayers()
{
  return (Collection)this.handle.getSpecificModifier(Collection.class).read(0);
}

public void setPlayers(Collection<String> players)
{
  this.handle.getSpecificModifier(Collection.class).write(0, players);
}
}
