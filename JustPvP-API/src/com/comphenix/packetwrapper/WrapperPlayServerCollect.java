package com.comphenix.packetwrapper;

import org.bukkit.World;
import org.bukkit.entity.Entity;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

public class WrapperPlayServerCollect
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.COLLECT;

public WrapperPlayServerCollect()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerCollect(PacketContainer packet)
{
  super(packet, TYPE);
}

public int getCollectedEntityID()
{
  return ((Integer)this.handle.getIntegers().read(0)).intValue();
}

public Entity getCollectedEntity(World world)
{
  return (Entity)this.handle.getEntityModifier(world).read(0);
}

public Entity getCollectedEntity(PacketEvent event)
{
  return getCollectedEntity(event.getPlayer().getWorld());
}

public void setCollectedEntityID(int value)
{
  this.handle.getIntegers().write(0, Integer.valueOf(value));
}

public int getCollectorEntityID()
{
  return ((Integer)this.handle.getIntegers().read(1)).intValue();
}

public void setCollectorEntityID(int value)
{
  this.handle.getIntegers().write(1, Integer.valueOf(value));
}

public Entity getCollectorEntity(World world)
{
  return (Entity)this.handle.getEntityModifier(world).read(1);
}

public Entity getCollectorEntity(PacketEvent event)
{
  return getCollectorEntity(event.getPlayer().getWorld());
}
}
