package com.comphenix.packetwrapper;

import org.bukkit.inventory.ItemStack;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerWindowItems
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.WINDOW_ITEMS;

public WrapperPlayServerWindowItems()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerWindowItems(PacketContainer packet)
{
  super(packet, TYPE);
}

public byte getWindowId()
{
  return ((Integer)this.handle.getIntegers().read(0)).byteValue();
}

public void setWindowId(byte value)
{
  this.handle.getIntegers().write(0, Integer.valueOf(value));
}

public ItemStack[] getItems()
{
  return (ItemStack[])this.handle.getItemArrayModifier().read(0);
}

public void setItems(ItemStack[] value)
{
  this.handle.getItemArrayModifier().write(0, value);
}
}
