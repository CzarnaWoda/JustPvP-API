package com.comphenix.packetwrapper;

import org.bukkit.inventory.ItemStack;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayClientWindowClick
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Client.WINDOW_CLICK;

public WrapperPlayClientWindowClick()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayClientWindowClick(PacketContainer packet)
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

public byte getMouseButton()
{
  return ((Integer)this.handle.getIntegers().read(2)).byteValue();
}

public void setMouseButton(byte value)
{
  this.handle.getIntegers().write(2, Integer.valueOf(value));
}

public short getActionNumber()
{
  return ((Short)this.handle.getShorts().read(0)).shortValue();
}

public void setActionNumber(short value)
{
  this.handle.getShorts().write(0, Short.valueOf(value));
}

public int getMode()
{
  return ((Integer)this.handle.getIntegers().read(3)).intValue();
}

public void setMode(int mode)
{
  this.handle.getIntegers().write(3, Integer.valueOf(mode));
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
