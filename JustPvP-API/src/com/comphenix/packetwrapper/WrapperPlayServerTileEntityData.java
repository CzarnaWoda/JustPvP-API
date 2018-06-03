package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.nbt.NbtBase;

public class WrapperPlayServerTileEntityData
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.TILE_ENTITY_DATA;

public WrapperPlayServerTileEntityData()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerTileEntityData(PacketContainer packet)
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

public short getY()
{
  return ((Integer)this.handle.getIntegers().read(1)).shortValue();
}

public void setY(short value)
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

public byte getAction()
{
  return ((Integer)this.handle.getIntegers().read(3)).byteValue();
}

public void setAction(byte value)
{
  this.handle.getIntegers().write(3, Integer.valueOf(value));
}

@SuppressWarnings("rawtypes")
public NbtBase<?> getNbtData()
{
  return (NbtBase)this.handle.getNbtModifier().read(0);
}

public void setNbtData(NbtBase<?> value)
{
  this.handle.getNbtModifier().write(0, value);
}
}

