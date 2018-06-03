package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerMapChunk
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.MAP_CHUNK;

public WrapperPlayServerMapChunk()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerMapChunk(PacketContainer packet)
{
  super(packet, TYPE);
}

public int getChunkX()
{
  return ((Integer)this.handle.getIntegers().read(0)).intValue();
}

public void setChunkX(int value)
{
  this.handle.getIntegers().write(0, Integer.valueOf(value));
}

public int getChunkZ()
{
  return ((Integer)this.handle.getIntegers().read(1)).intValue();
}

public void setChunkZ(int value)
{
  this.handle.getIntegers().write(1, Integer.valueOf(value));
}

public boolean getGroundUpContinuous()
{
  return ((Boolean)this.handle.getSpecificModifier(Boolean.TYPE).read(0)).booleanValue();
}

public void setGroundUpContinuous(boolean value)
{
  this.handle.getSpecificModifier(Boolean.TYPE).write(0, Boolean.valueOf(value));
}

public short getPrimaryBitMap()
{
  return ((Integer)this.handle.getIntegers().read(2)).shortValue();
}

public void setPrimaryBitMap(short value)
{
  this.handle.getIntegers().write(2, Integer.valueOf(value));
}

public short getAddBitMap()
{
  return ((Integer)this.handle.getIntegers().read(3)).shortValue();
}

public void setAddBitMap(short value)
{
  this.handle.getIntegers().write(3, Integer.valueOf(value));
}

public int getCompressedSize()
{
  return ((Integer)this.handle.getIntegers().read(4)).intValue();
}

public void setCompressedSize(int value)
{
  this.handle.getIntegers().write(4, Integer.valueOf(value));
}

public byte[] getCompressedData()
{
  return (byte[])this.handle.getByteArrays().read(0);
}

public void setCompressedData(byte[] value)
{
  this.handle.getByteArrays().write(0, (byte[])value);
}

public byte[] getUncompressedData()
{
  return (byte[])this.handle.getByteArrays().read(1);
}

public void setUncompressedData(byte[] value)
{
  this.handle.getByteArrays().write(1, (byte[])value);
}
}
