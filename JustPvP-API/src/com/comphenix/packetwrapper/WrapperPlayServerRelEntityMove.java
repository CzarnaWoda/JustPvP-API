package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerRelEntityMove
extends WrapperPlayServerEntity
{
public static final PacketType TYPE = PacketType.Play.Server.REL_ENTITY_MOVE;

public WrapperPlayServerRelEntityMove()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerRelEntityMove(PacketContainer packet)
{
  super(packet, TYPE);
}

public double getDx()
{
  return ((Byte)this.handle.getBytes().read(0)).byteValue() / 32.0D;
}

public void setDx(double value)
{
  if (Math.abs(value) > 4.0D) {
    throw new IllegalArgumentException("Displacement cannot exceed 4 meters.");
  }
  this.handle.getBytes().write(0, Byte.valueOf((byte)(int)Math.min(Math.floor(value * 32.0D), 127.0D)));
}

public double getDy()
{
  return ((Byte)this.handle.getBytes().read(1)).byteValue() / 32.0D;
}

public void setDy(double value)
{
  if (Math.abs(value) > 4.0D) {
    throw new IllegalArgumentException("Displacement cannot exceed 4 meters.");
  }
  this.handle.getBytes().write(1, Byte.valueOf((byte)(int)Math.min(Math.floor(value * 32.0D), 127.0D)));
}

public double getDz()
{
  return ((Byte)this.handle.getBytes().read(2)).byteValue() / 32.0D;
}

public void setDz(double value)
{
  if (Math.abs(value) > 4.0D) {
    throw new IllegalArgumentException("Displacement cannot exceed 4 meters.");
  }
  this.handle.getBytes().write(2, Byte.valueOf((byte)(int)Math.min(Math.floor(value * 32.0D), 127.0D)));
}
}

