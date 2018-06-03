package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerHeldItemSlot
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.HELD_ITEM_SLOT;

public WrapperPlayServerHeldItemSlot()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerHeldItemSlot(PacketContainer packet)
{
  super(packet, TYPE);
}

public short getSlotId()
{
  return ((Integer)this.handle.getIntegers().read(0)).shortValue();
}

public void setSlotId(short value)
{
  this.handle.getIntegers().write(0, Integer.valueOf(value));
}
}
