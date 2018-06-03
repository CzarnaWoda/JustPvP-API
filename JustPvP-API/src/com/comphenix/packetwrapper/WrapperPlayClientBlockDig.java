package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.IntEnum;


public class WrapperPlayClientBlockDig
  extends AbstractPacket
{
  public static final PacketType TYPE = PacketType.Play.Client.BLOCK_DIG;
  
  public static enum Status
  {
    STARTED_DIGGING,  CANCELLED_DIGGING,  FINISHED_DIGGING,  DROP_ITEM_STACK,  DROP_ITEM,  SHOOT_ARROW;
    
    private Status() {}
  }
  
  public static class BlockSide
    extends IntEnum
  {
    public static final int BOTTOM = 0;
    public static final int TOP = 1;
    public static final int BEHIND = 2;
    public static final int FRONT = 3;
    public static final int LEFT = 4;
    public static final int RIGHT = 5;
    private static BlockSide INSTANCE = new BlockSide();
    
    public static BlockSide getInstance()
    {
      return INSTANCE;
    }
    
    private static final int[] xOffset = { 0, 0, 0, 0, -1, 1 };
    private static final int[] yOffset = { -1, 1, 0, 0, 0, 0 };
    private static final int[] zOffset = { 0, 0, -1, 1, 0, 0 };
    
    public static int getXOffset(int blockFace)
    {
      return xOffset[blockFace];
    }
    
    public static int getYOffset(int blockFace)
    {
      return yOffset[blockFace];
    }
    
    public static int getZOffset(int blockFace)
    {
      return zOffset[blockFace];
    }
  }
  
  public WrapperPlayClientBlockDig()
  {
    super(new PacketContainer(TYPE), TYPE);
    this.handle.getModifier().writeDefaults();
  }
  
  public WrapperPlayClientBlockDig(PacketContainer packet)
  {
    super(packet, TYPE);
  }
  
  public Status getStatus()
  {
    return Status.values()[((Integer)this.handle.getIntegers().read(4)).intValue()];
  }
  
  public void setStatus(Status value)
  {
    this.handle.getIntegers().write(4, Integer.valueOf(value.ordinal()));
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
  
  public int getFace()
  {
    return ((Integer)this.handle.getIntegers().read(3)).byteValue();
  }
  
  public void setFace(int value)
  {
    this.handle.getIntegers().write(3, Integer.valueOf(value));
  }
}

