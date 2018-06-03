package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayClientCloseWindow
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Client.CLOSE_WINDOW;

public WrapperPlayClientCloseWindow()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayClientCloseWindow(PacketContainer packet)
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
