package com.comphenix.packetwrapper;

import org.bukkit.inventory.ItemStack;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayClientSetCreativeSlot
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Client.SET_CREATIVE_SLOT;

public WrapperPlayClientSetCreativeSlot()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayClientSetCreativeSlot(PacketContainer packet)
{
  super(packet, TYPE);
}

public short getSlot()
{
  return ((Integer)this.handle.getIntegers().read(0)).shortValue();
}

public void setSlot(short value)
{
  this.handle.getIntegers().write(0, Integer.valueOf(value));
}

public ItemStack getClickedItem()
{
  return (ItemStack)this.handle.getItemModifier().read(0);
}

public void setClickedItem(ItemStack value)
{
  this.handle.getItemModifier().write(0, value);
}
}
