package com.comphenix.packetwrapper;

import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

public class WrapperPlayServerEntityEquipment
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.ENTITY_EQUIPMENT;

public WrapperPlayServerEntityEquipment()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerEntityEquipment(PacketContainer packet)
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

public short getSlot()
{
  return ((Integer)this.handle.getIntegers().read(1)).shortValue();
}

public void setSlot(short value)
{
  this.handle.getIntegers().write(1, Integer.valueOf(value));
}

public ItemStack getItem()
{
  return (ItemStack)this.handle.getItemModifier().read(0);
}

public void setItem(ItemStack value)
{
  this.handle.getItemModifier().write(0, value);
}
}

