package com.comphenix.packetwrapper;

import org.bukkit.WorldType;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers;

public class WrapperPlayServerRespawn
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.RESPAWN;

public WrapperPlayServerRespawn()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerRespawn(PacketContainer packet)
{
  super(packet, TYPE);
}

public int getDimension()
{
  return ((Integer)this.handle.getIntegers().read(0)).intValue();
}

public void setDimension(int value)
{
  this.handle.getIntegers().write(0, Integer.valueOf(value));
}

public EnumWrappers.Difficulty getDifficulty()
{
  return (EnumWrappers.Difficulty)this.handle.getDifficulties().read(0);
}

public void setDifficulty(EnumWrappers.Difficulty value)
{
  this.handle.getDifficulties().write(0, value);
}

public EnumWrappers.NativeGameMode getGameMode()
{
  return (EnumWrappers.NativeGameMode)this.handle.getGameModes().read(0);
}

public void setGameMode(EnumWrappers.NativeGameMode mode)
{
  this.handle.getGameModes().write(0, mode);
}

public WorldType getLevelType()
{
  return (WorldType)this.handle.getWorldTypeModifier().read(0);
}

public void setLevelType(WorldType value)
{
  this.handle.getWorldTypeModifier().write(0, value);
}
}
