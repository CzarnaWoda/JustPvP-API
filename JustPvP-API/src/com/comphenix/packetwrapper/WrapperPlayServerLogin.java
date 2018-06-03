package com.comphenix.packetwrapper;

import org.bukkit.World;
import org.bukkit.WorldType;
import org.bukkit.entity.Entity;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.EnumWrappers;

public class WrapperPlayServerLogin
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.LOGIN;

public WrapperPlayServerLogin()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerLogin(PacketContainer packet)
{
  super(packet, TYPE);
}

public int getEntityId()
{
  return ((Integer)this.handle.getIntegers().read(0)).intValue();
}

public void setEntityId(int value)
{
  this.handle.getIntegers().write(0, Integer.valueOf(value));
}

public Entity getEntity(World world)
{
  return (Entity)this.handle.getEntityModifier(world).read(0);
}

public Entity getEntity(PacketEvent event)
{
  return getEntity(event.getPlayer().getWorld());
}

public EnumWrappers.NativeGameMode getGamemode()
{
  return (EnumWrappers.NativeGameMode)this.handle.getGameModes().read(0);
}

public void setGamemode(EnumWrappers.NativeGameMode value)
{
  this.handle.getGameModes().write(0, value);
}

public boolean isHardcore()
{
  return ((Boolean)this.handle.getBooleans().read(0)).booleanValue();
}

public void setHardcore(boolean value)
{
  this.handle.getBooleans().write(0, Boolean.valueOf(value));
}

public int getDimension()
{
  return ((Integer)this.handle.getIntegers().read(1)).intValue();
}

public void setDimension(int value)
{
  this.handle.getIntegers().write(1, Integer.valueOf(value));
}

public EnumWrappers.Difficulty getDifficulty()
{
  return (EnumWrappers.Difficulty)this.handle.getDifficulties().read(0);
}

public void setDifficulty(EnumWrappers.Difficulty difficulty)
{
  this.handle.getDifficulties().write(0, difficulty);
}

public byte getMaxPlayers()
{
  return ((Integer)this.handle.getIntegers().read(2)).byteValue();
}

public void setMaxPlayers(byte value)
{
  this.handle.getIntegers().write(2, Integer.valueOf(value));
}

public WorldType getLevelType()
{
  return (WorldType)this.handle.getWorldTypeModifier().read(0);
}

public void setLevelType(WorldType type)
{
  this.handle.getWorldTypeModifier().write(0, type);
}
}
