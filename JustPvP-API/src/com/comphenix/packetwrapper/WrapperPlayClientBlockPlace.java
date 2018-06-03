package com.comphenix.packetwrapper;

import org.bukkit.inventory.ItemStack;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayClientBlockPlace
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Client.BLOCK_PLACE;

public WrapperPlayClientBlockPlace()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayClientBlockPlace(PacketContainer packet)
{
  super(packet, TYPE);
}

public int getX()
{
  return ((Integer)this.handle.getIntegers().read(0)).intValue();
}

public void setX(int value)
{
  this.handle.getIntegers().write(0, Integer.valueOf(value));
}

public byte getY()
{
  return ((Integer)this.handle.getIntegers().read(1)).byteValue();
}

public void setY(byte value)
{
  this.handle.getIntegers().write(1, Integer.valueOf(value));
}

public int getZ()
{
  return ((Integer)this.handle.getIntegers().read(2)).intValue();
}

public void setZ(int value)
{
  this.handle.getIntegers().write(2, Integer.valueOf(value));
}

public byte getDirection()
{
  return ((Integer)this.handle.getIntegers().read(3)).byteValue();
}

public void setDirection(byte value)
{
  this.handle.getIntegers().write(3, Integer.valueOf(value));
}

public ItemStack getHeldItem()
{
  return (ItemStack)this.handle.getItemModifier().read(0);
}

public void setHeldItem(ItemStack value)
{
  this.handle.getItemModifier().write(0, value);
}

public float getCursorPositionX()
{
  return ((Float)this.handle.getFloat().read(0)).floatValue();
}

public void setCursorPositionX(float value)
{
  this.handle.getFloat().write(0, Float.valueOf(value));
}

public float getCursorPositionY()
{
  return ((Float)this.handle.getFloat().read(1)).floatValue();
}

public void setCursorPositionY(float value)
{
  this.handle.getFloat().write(1, Float.valueOf(value));
}

public byte getCursorPositionZ()
{
  return ((Float)this.handle.getFloat().read(2)).byteValue();
}

public void setCursorPositionZ(byte value)
{
  this.handle.getFloat().write(2, Float.valueOf(value));
}
}
