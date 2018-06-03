package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayClientEnchantItem
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Client.ENCHANT_ITEM;

public WrapperPlayClientEnchantItem()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayClientEnchantItem(PacketContainer packet)
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

public byte getEnchantment()
{
  return ((Integer)this.handle.getIntegers().read(1)).byteValue();
}

public void setEnchantment(byte value)
{
  this.handle.getIntegers().write(1, Integer.valueOf(value));
}
}
