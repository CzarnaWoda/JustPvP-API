package com.comphenix.packetwrapper;

import org.bukkit.inventory.ItemStack;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerSetSlot
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.SET_SLOT;

public WrapperPlayServerSetSlot()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerSetSlot(PacketContainer packet)
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

public short getSlot()
{
  return ((Integer)this.handle.getIntegers().read(1)).shortValue();
}

public void setSlot(short value)
{
  this.handle.getIntegers().write(1, Integer.valueOf(value));
}

public ItemStack getSlotData()
{
  return (ItemStack)this.handle.getItemModifier().read(0);
}

public void setSlotData(ItemStack value)
{
  this.handle.getItemModifier().write(0, value);
}
}