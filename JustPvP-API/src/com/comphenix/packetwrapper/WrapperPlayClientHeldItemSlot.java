package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayClientHeldItemSlot
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Client.HELD_ITEM_SLOT;

public WrapperPlayClientHeldItemSlot()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayClientHeldItemSlot(PacketContainer packet)
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
}
