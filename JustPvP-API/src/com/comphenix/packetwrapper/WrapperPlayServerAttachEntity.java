package com.comphenix.packetwrapper;

import org.bukkit.World;
import org.bukkit.entity.Entity;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

public class WrapperPlayServerAttachEntity
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.ATTACH_ENTITY;

public WrapperPlayServerAttachEntity()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerAttachEntity(PacketContainer packet)
{
  super(packet, TYPE);
}

public boolean getLeached()
{
  return ((Integer)this.handle.getIntegers().read(0)).intValue() != 0;
}

public void setLeached(boolean value)
{
  this.handle.getIntegers().write(0, Integer.valueOf(value ? 1 : 0));
}

public int getEntityId()
{
  return ((Integer)this.handle.getIntegers().read(1)).intValue();
}

public void setEntityId(int value)
{
  this.handle.getIntegers().write(1, Integer.valueOf(value));
}

public Entity getEntity(World world)
{
  return (Entity)this.handle.getEntityModifier(world).read(1);
}

public Entity getEntity(PacketEvent event)
{
  return getEntity(event.getPlayer().getWorld());
}

public int getVehicleId()
{
  return ((Integer)this.handle.getIntegers().read(2)).intValue();
}

public void setVehicleId(int value)
{
  this.handle.getIntegers().write(2, Integer.valueOf(value));
}

public Entity getVehicle(World world)
{
  return (Entity)this.handle.getEntityModifier(world).read(2);
}

public Entity getVehicle(PacketEvent event)
{
  return getVehicle(event.getPlayer().getWorld());
}
}
