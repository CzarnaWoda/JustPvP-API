package com.comphenix.packetwrapper;

import java.util.Arrays;
import java.util.List;

import org.bukkit.event.inventory.InventoryType;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerOpenWindow
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.OPEN_WINDOW;
private static List<InventoryType> inventoryByID = Arrays.asList(new InventoryType[] { InventoryType.CHEST, InventoryType.WORKBENCH, InventoryType.FURNACE, InventoryType.DISPENSER, InventoryType.ENCHANTING, InventoryType.BREWING, InventoryType.MERCHANT, InventoryType.BEACON, InventoryType.ANVIL });

public WrapperPlayServerOpenWindow()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerOpenWindow(PacketContainer packet)
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

public InventoryType getInventoryType()
{
  int id = ((Integer)this.handle.getIntegers().read(1)).intValue();
  if ((id >= 0) && (id <= inventoryByID.size())) {
    return (InventoryType)inventoryByID.get(id);
  }
  throw new IllegalArgumentException("Cannot find inventory type " + id);
}

public void setInventoryType(InventoryType value)
{
  int id = inventoryByID.indexOf(value);
  if (id > 0) {
    this.handle.getIntegers().write(1, Integer.valueOf(id));
  } else {
    throw new IllegalArgumentException("Cannot find the ID of " + value);
  }
}

public String getWindowTitle()
{
  return (String)this.handle.getStrings().read(0);
}

public void setWindowTitle(String value)
{
  this.handle.getStrings().write(0, value);
}

public byte getNumberOfSlots()
{
  return ((Integer)this.handle.getIntegers().read(2)).byteValue();
}

public void setNumberOfSlots(byte value)
{
  this.handle.getIntegers().write(2, Integer.valueOf(value));
}

public void setTitleExact(boolean value)
{
  this.handle.getSpecificModifier(Boolean.TYPE).write(0, Boolean.valueOf(value));
}

public boolean isTitleExact()
{
  return ((Boolean)this.handle.getSpecificModifier(Boolean.TYPE).read(0)).booleanValue();
}

public int getEntityId()
{
  return ((Integer)this.handle.getIntegers().read(3)).intValue();
}

public void setEntityId(int value)
{
  this.handle.getIntegers().write(3, Integer.valueOf(value));
}
}

