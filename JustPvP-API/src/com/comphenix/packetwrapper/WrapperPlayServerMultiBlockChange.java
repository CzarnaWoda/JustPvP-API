package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.ChunkCoordIntPair;


public class WrapperPlayServerMultiBlockChange
  extends AbstractPacket
{
  public static final PacketType TYPE = PacketType.Play.Server.MULTI_BLOCK_CHANGE;
  
  public WrapperPlayServerMultiBlockChange()
  {
    super(new PacketContainer(TYPE), TYPE);
    this.handle.getModifier().writeDefaults();
  }
  
  public WrapperPlayServerMultiBlockChange(PacketContainer packet)
  {
    super(packet, TYPE);
  }
  
  public int getChunkX()
  {
    return getChunk().getChunkX();
  }
  
  public void setChunkX(int index)
  {
    setChunk(new ChunkCoordIntPair(index, getChunkZ()));
  }
  
  public int getChunkZ()
  {
    return getChunk().getChunkZ();
  }
  
  public void setChunkZ(int index)
  {
    setChunk(new ChunkCoordIntPair(getChunkX(), index));
  }
  
  public ChunkCoordIntPair getChunk()
  {
    return (ChunkCoordIntPair)this.handle.getChunkCoordIntPairs().read(0);
  }
  
  public void setChunk(ChunkCoordIntPair value)
  {
    this.handle.getChunkCoordIntPairs().write(0, value);
  }
  
  public short getRecordCount()
  {
    return ((Integer)this.handle.getIntegers().read(0)).shortValue();
  }
  
  public void setRecordCount(short value)
  {
    this.handle.getIntegers().write(0, Integer.valueOf(value));
  }
  
  public byte[] getRecordData()
  {
    return (byte[])this.handle.getByteArrays().read(0);
  }
  
  public void setRecordData(byte[] value)
  {
    setRecordCount((short)value.length);
    this.handle.getByteArrays().write(0, value);
  }
  
  public void setRecordData(BlockChangeArray array)
  {
    setRecordData(array.toByteArray());
  }
  
  public BlockChangeArray getRecordDataArray()
  {
    return new BlockChangeArray(getRecordData());
  }
}
