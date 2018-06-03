package com.comphenix.packetwrapper;

import org.bukkit.Instrument;
import org.bukkit.Material;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.IntEnum;

public class WrapperPlayServerBlockAction
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.BLOCK_ACTION;

public WrapperPlayServerBlockAction()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerBlockAction(PacketContainer packet)
{
  super(packet, TYPE);
}

public static class BlockFaceDirection
  extends IntEnum
{
  public static final int DOWN = 0;
  public static final int UP = 1;
  public static final int SOUTH = 2;
  public static final int WEST = 3;
  public static final int NORTH = 4;
  public static final int EAST = 5;
  private static BlockFaceDirection INSTANCE = new BlockFaceDirection();
  
  public static BlockFaceDirection getInstance()
  {
    return INSTANCE;
  }
}

public int getX()
{
  return ((Integer)this.handle.getIntegers().read(0)).intValue();
}

public void setX(int value)
{
  this.handle.getIntegers().write(0, Integer.valueOf(value));
}

public int getY()
{
  return ((Integer)this.handle.getIntegers().read(1)).intValue();
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

@SuppressWarnings("deprecation")
public short getBlockId()
{
  return (short)getBlockType().getId();
}

@SuppressWarnings("deprecation")
public void setBlockId(short value)
{
  setBlockType(Material.getMaterial(value));
}

public Material getBlockType()
{
  return (Material)this.handle.getBlocks().read(0);
}

public void setBlockType(Material value)
{
  this.handle.getBlocks().write(0, value);
}

public byte getByte1()
{
  return ((Integer)this.handle.getIntegers().read(3)).byteValue();
}

public void setByte1(byte value)
{
  this.handle.getIntegers().write(3, Integer.valueOf(value));
}

public byte getByte2()
{
  return ((Integer)this.handle.getIntegers().read(4)).byteValue();
}

public void setByte2(byte value)
{
  this.handle.getIntegers().write(4, Integer.valueOf(value));
}

public NoteBlockData getNoteBlockData()
{
  return new NoteBlockData();
}

public PistionData getPistonData()
{
  return new PistionData();
}

public ChestData getChestData()
{
  return new ChestData();
}

public class NoteBlockData
{
  public NoteBlockData() {}
  
  @SuppressWarnings("deprecation")
public Instrument getInstrument()
  {
    return Instrument.getByType(WrapperPlayServerBlockAction.this.getByte1());
  }
  
  @SuppressWarnings("deprecation")
public void setInstrument(Instrument value)
  {
    WrapperPlayServerBlockAction.this.setByte1(value.getType());
  }
  
  public byte getPitch()
  {
    return WrapperPlayServerBlockAction.this.getByte2();
  }
  
  public void setPitch(byte value)
  {
    WrapperPlayServerBlockAction.this.setByte2(value);
  }
}

public class PistionData
{
  public PistionData() {}
  
  public byte getState()
  {
    return WrapperPlayServerBlockAction.this.getByte1();
  }
  
  public void setState(byte value)
  {
    WrapperPlayServerBlockAction.this.setByte1(value);
  }
  
  public int getDirection()
  {
    return WrapperPlayServerBlockAction.this.getByte2();
  }
  
  public void setDirection(int value)
  {
    WrapperPlayServerBlockAction.this.setByte2((byte)value);
  }
}

public class ChestData
{
  public ChestData() {}
  
  public boolean isOpen()
  {
    return WrapperPlayServerBlockAction.this.getByte2() != 0;
  }
  
  public void setOpen(boolean open)
  {
    WrapperPlayServerBlockAction.this.setByte2((byte)(open ? 1 : 0));
  }
}
}

