package com.comphenix.packetwrapper;

import org.bukkit.Location;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

public class WrapperPlayServerOpenSignEntity
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.OPEN_SIGN_ENTITY;

public WrapperPlayServerOpenSignEntity()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerOpenSignEntity(PacketContainer packet)
{
  super(packet, TYPE);
}

public int getX()
{
  return ((Integer)this.handle.getIntegers().read(0)).intValue();
}

public void setX(int value)
{
  this.handle.getIntegers().write(0, Integer.valueOf(value));
}

public int getY()
{
  return ((Integer)this.handle.getIntegers().read(1)).intValue();
}

public void setY(int value)
{
  this.handle.getIntegers().write(1, Integer.valueOf(value));
}

public int getZ()
{
  return ((Integer)this.handle.getIntegers().read(2)).intValue();
}

public void setZ(int value)
{
  this.handle.getIntegers().write(2, Integer.valueOf(value));
}

public Location getLocation(PacketEvent event)
{
  return new Location(event.getPlayer().getWorld(), getX(), getY(), getZ());
}

public void setLocation(Location loc)
{
  setX(loc.getBlockX());
  setY((byte)loc.getBlockY());
  setZ(loc.getBlockZ());
}
}