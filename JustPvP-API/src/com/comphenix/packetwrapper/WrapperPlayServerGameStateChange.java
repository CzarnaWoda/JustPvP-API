package com.comphenix.packetwrapper;

import org.bukkit.GameMode;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerGameStateChange
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.GAME_STATE_CHANGE;

public WrapperPlayServerGameStateChange()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerGameStateChange(PacketContainer packet)
{
  super(packet, TYPE);
}

public static class Reasons
{
  public static final int INVALID_BED = 0;
  public static final int BEGIN_RAINING = 1;
  public static final int END_RAINING = 2;
  public static final int CHANGE_GAME_MODE = 3;
  public static final int ENTER_CREDITS = 4;
  public static final int DEMO_MESSAGES = 5;
  public static final int ARROW_HITTING_PLAYER = 6;
  public static final int SKY_FADE_VALUE = 7;
  public static final int SKY_FADE_TIME = 8;
  private static final Reasons INSTANCE = new Reasons();
  
  public static Reasons getInstance()
  {
    return INSTANCE;
  }
}

public int getReason()
{
  return ((Integer)this.handle.getIntegers().read(0)).intValue();
}

public void setReason(int value)
{
  this.handle.getIntegers().write(0, Integer.valueOf(value));
}

@SuppressWarnings("deprecation")
public GameMode getGameMode()
{
  return GameMode.getByValue(((Integer)this.handle.getIntegers().read(1)).intValue());
}

@SuppressWarnings("deprecation")
public void setGameMode(GameMode value)
{
  this.handle.getIntegers().write(1, Integer.valueOf(value.getValue()));
}
}
