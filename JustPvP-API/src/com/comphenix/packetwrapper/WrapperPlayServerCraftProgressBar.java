package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerCraftProgressBar
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.CRAFT_PROGRESS_BAR;

public static class FurnaceProperties
{
  public static final int PROGRESS_ARROW = 0;
  public static final int PROGRESS_FIRE_ICON = 1;
  private static FurnaceProperties INSTANCE = new FurnaceProperties();
  
  public static FurnaceProperties getInstace()
  {
    return INSTANCE;
  }
}

public WrapperPlayServerCraftProgressBar()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerCraftProgressBar(PacketContainer packet)
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

public short getProperty()
{
  return ((Integer)this.handle.getIntegers().read(1)).shortValue();
}

public void setProperty(short value)
{
  this.handle.getIntegers().write(1, Integer.valueOf(value));
}

public short getValue()
{
  return ((Integer)this.handle.getIntegers().read(2)).shortValue();
}

public void setValue(short value)
{
  this.handle.getIntegers().write(2, Integer.valueOf(value));
}
}
