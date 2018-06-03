package com.comphenix.packetwrapper;

import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Painting;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.injector.PacketConstructor;

public class WrapperPlayServerSpawnEntityPainting
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.SPAWN_ENTITY_PAINTING;
private static PacketConstructor entityConstructor;

public WrapperPlayServerSpawnEntityPainting()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerSpawnEntityPainting(PacketContainer packet)
{
  super(packet, TYPE);
}

public WrapperPlayServerSpawnEntityPainting(Painting painting)
{
  super(fromPainting(painting), TYPE);
}

private static PacketContainer fromPainting(Painting painting)
{
  if (entityConstructor == null) {
    entityConstructor = ProtocolLibrary.getProtocolManager().createPacketConstructor(TYPE, new Object[] { painting });
  }
  return entityConstructor.createPacket(new Object[] { painting });
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

public String getTitle()
{
  return (String)this.handle.getStrings().read(0);
}

public void setTitle(String value)
{
  this.handle.getStrings().write(0, value);
}

public int getX()
{
  return ((Integer)this.handle.getIntegers().read(1)).intValue();
}

public void setX(int value)
{
  this.handle.getIntegers().write(1, Integer.valueOf(value));
}

public int getY()
{
  return ((Integer)this.handle.getIntegers().read(2)).intValue();
}

public void setY(int value)
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

public int getDirection()
{
  return ((Integer)this.handle.getIntegers().read(4)).intValue();
}

public void setDirection(int value)
{
  this.handle.getIntegers().write(4, Integer.valueOf(value));
}
}

