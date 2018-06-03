package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerCloseWindow
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.CLOSE_WINDOW;

public WrapperPlayServerCloseWindow()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerCloseWindow(PacketContainer packet)
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
}
