package com.comphenix.packetwrapper;

import org.bukkit.World;
import org.bukkit.entity.Entity;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

public class WrapperPlayServerSpawnEntityExperienceOrb
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.SPAWN_ENTITY_EXPERIENCE_ORB;

public WrapperPlayServerSpawnEntityExperienceOrb()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerSpawnEntityExperienceOrb(PacketContainer packet)
{
  super(packet, TYPE);
}

public int getEntityId()
{
  return ((Integer)this.handle.getIntegers().read(0)).intValue();
}

public Entity getEntity(World world)
{
  return (Entity)this.handle.getEntityModifier(world).read(0);
}

public Entity getEntity(PacketEvent event)
{
  return getEntity(event.getPlayer().getWorld());
}

public void setEntityId(int value)
{
  this.handle.getIntegers().write(0, Integer.valueOf(value));
}

public double getX()
{
  return ((Integer)this.handle.getIntegers().read(1)).intValue() / 32.0D;
}

public void setX(double value)
{
  this.handle.getIntegers().write(1, Integer.valueOf((int)Math.floor(value * 32.0D)));
}

public double getY()
{
  return ((Integer)this.handle.getIntegers().read(2)).intValue() / 32.0D;
}

public void setY(double value)
{
  this.handle.getIntegers().write(2, Integer.valueOf((int)Math.floor(value * 32.0D)));
}

public double getZ()
{
  return ((Integer)this.handle.getIntegers().read(3)).intValue() / 32.0D;
}

public void setZ(double value)
{
  this.handle.getIntegers().write(3, Integer.valueOf((int)Math.floor(value * 32.0D)));
}

public short getCount()
{
  return ((Integer)this.handle.getIntegers().read(4)).shortValue();
}

public void setCount(short value)
{
  this.handle.getIntegers().write(4, Integer.valueOf(value));
}
}
