package com.comphenix.packetwrapper;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

public class WrapperPlayServerBed
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.BED;

public WrapperPlayServerBed()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerBed(PacketContainer packet)
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

public int getX()
{
  return ((Integer)this.handle.getIntegers().read(1)).intValue();
}

public void setX(int value)
{
  this.handle.getIntegers().write(1, Integer.valueOf(value));
}

public byte getY()
{
  return ((Integer)this.handle.getIntegers().read(2)).byteValue();
}

public void setY(byte value)
{
  this.handle.getIntegers().write(2, Integer.valueOf(value));
}

public int getZ()
{
  return ((Integer)this.handle.getIntegers().read(3)).intValue();
}

public void setZ(int value)
{
  this.handle.getIntegers().write(3, Integer.valueOf(value));
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

