package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerMapChunkBulk extends AbstractPacket
{
    public static final PacketType TYPE;
    
    public WrapperPlayServerMapChunkBulk() {
        super(new PacketContainer(WrapperPlayServerMapChunkBulk.TYPE), WrapperPlayServerMapChunkBulk.TYPE);
        this.handle.getModifier().writeDefaults();
    }
    
    public WrapperPlayServerMapChunkBulk(final PacketContainer packet) {
        super(packet, WrapperPlayServerMapChunkBulk.TYPE);
    }
    
    public int getDataLength() {
        return (int)this.handle.getIntegers().read(0);
    }
    
    public void setDataLength(int value)
    {
      this.handle.getIntegers().write(0, Integer.valueOf(value));
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean getSkyLightSent() {
        return (boolean)this.handle.getSpecificModifier((Class)Boolean.TYPE).read(0);
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })

    public void setSkyLightSent(final boolean value) {
        this.handle.getSpecificModifier((Class)Boolean.TYPE).write(0, (Object)value);
    }
    
    public int[] getChunksX() {
        return (int[])this.handle.getIntegerArrays().read(0);
    }
    
    public void setChunksX(int[] value)
    {
      this.handle.getIntegerArrays().write(0, value);
    }
    
    public int[] getChunksY()
    {
      return (int[])this.handle.getIntegerArrays().read(1);
    }
    
    public void setChunksY(int[] value)
    {
      this.handle.getIntegerArrays().write(1, value);
    }
    
    public int[] getChunksMask() {
        return (int[])this.handle.getIntegerArrays().read(2);
    }
    
    public void setChunksMask(int[] value)
    {
      this.handle.getIntegerArrays().write(2, value);
    }
    
    public int[] getChunksExtraMask() {
        return (int[])this.handle.getIntegerArrays().read(3);
    }
    
    public void setChunksExtraMask(int[] value)
    {
      this.handle.getIntegerArrays().write(3, value);
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })

    public byte[][] getChunksInflatedBuffers() {
        return (byte[][])this.handle.getSpecificModifier((Class)byte[][].class).read(0);
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })

    public void setChunksExtraMask(final byte[][] value) {
        this.handle.getSpecificModifier((Class)byte[][].class).write(0, (Object)value);
    }
    
    public byte[] getUncompressedData()
    {
      return (byte[])this.handle.getByteArrays().read(1);
    }
    
    public void setUncompressedData(byte[] value)
    {
      this.handle.getByteArrays().write(1, value);
    }
    
    static {
        TYPE = PacketType.Play.Server.MAP_CHUNK_BULK;
    }
}
