package com.comphenix.packetwrapper;

import java.util.List;

import org.bukkit.World;
import org.bukkit.entity.Entity;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedAttribute;

public class WrapperPlayServerUpdateAttributes
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.UPDATE_ATTRIBUTES;

public WrapperPlayServerUpdateAttributes()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerUpdateAttributes(PacketContainer packet)
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

@SuppressWarnings({ "unchecked", "rawtypes" })
public List<WrappedAttribute> getAttributes()
{
  return (List)this.handle.getAttributeCollectionModifier().read(0);
}

public void setAttributes(List<WrappedAttribute> value)
{
  this.handle.getAttributeCollectionModifier().write(0, value);
}
}
