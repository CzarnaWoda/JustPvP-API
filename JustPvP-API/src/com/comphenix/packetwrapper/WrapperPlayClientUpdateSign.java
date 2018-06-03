package com.comphenix.packetwrapper;

import javax.annotation.Nonnull;

import org.bukkit.Location;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

public class WrapperPlayClientUpdateSign
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Client.UPDATE_SIGN;

public WrapperPlayClientUpdateSign()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayClientUpdateSign(PacketContainer packet)
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

public short getY()
{
  return ((Integer)this.handle.getIntegers().read(1)).shortValue();
}

public void setY(short value)
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
  if (loc == null) {
    throw new IllegalArgumentException("Location cannot be NULL.");
  }
  setX(loc.getBlockX());
  setY((short)loc.getBlockY());
  setZ(loc.getBlockZ());
}

public String[] getLines()
{
  return (String[])this.handle.getStringArrays().read(0);
}

public void setLines(@Nonnull String[] lines)
{
  if (lines == null) {
    throw new IllegalArgumentException("Array cannot be NULL.");
  }
  if (lines.length != 4) {
    throw new IllegalArgumentException("The lines array must be four elements long.");
  }
  this.handle.getStringArrays().write(0, lines);
}
}
