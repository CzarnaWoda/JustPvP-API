package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayClientTransaction
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Client.TRANSACTION;

public WrapperPlayClientTransaction()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayClientTransaction(PacketContainer packet)
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

public short getActionNumber()
{
  return ((Short)this.handle.getShorts().read(0)).shortValue();
}

public void setActionNumber(short value)
{
  this.handle.getShorts().write(0, Short.valueOf(value));
}

public boolean getAccepted()
{
  return ((Boolean)this.handle.getSpecificModifier(Boolean.TYPE).read(0)).booleanValue();
}

public void setAccepted(boolean value)
{
  this.handle.getSpecificModifier(Boolean.TYPE).write(0, Boolean.valueOf(value));
}
}
