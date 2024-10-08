package com.comphenix.packetwrapper;

import org.bukkit.World;
import org.bukkit.entity.Entity;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

public class WrapperPlayServerEntityVelocity
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.ENTITY_VELOCITY;

public WrapperPlayServerEntityVelocity()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerEntityVelocity(PacketContainer packet)
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

public double getVelocityX()
{
  return ((Integer)this.handle.getIntegers().read(1)).intValue() / 8000.0D;
}

public void setVelocityX(double value)
{
  this.handle.getIntegers().write(1, Integer.valueOf((int)(value * 8000.0D)));
}

public double getVelocityY()
{
  return ((Integer)this.handle.getIntegers().read(2)).intValue() / 8000.0D;
}

public void setVelocityY(double value)
{
  this.handle.getIntegers().write(2, Integer.valueOf((int)(value * 8000.0D)));
}

public double getVelocityZ()
{
  return ((Integer)this.handle.getIntegers().read(3)).intValue() / 8000.0D;
}

public void setVelocityZ(double value)
{
  this.handle.getIntegers().write(3, Integer.valueOf((int)(value * 8000.0D)));
}
}

