package com.comphenix.packetwrapper;

import org.bukkit.World;
import org.bukkit.entity.Entity;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.injector.PacketConstructor;
import com.comphenix.protocol.reflect.IntEnum;

public class WrapperPlayServerSpawnEntity
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.SPAWN_ENTITY;
private static PacketConstructor entityConstructor;

public static class ObjectTypes
  extends IntEnum
{
  public static final int BOAT = 1;
  public static final int ITEM_STACK = 2;
  public static final int MINECART = 10;
  public static final int MINECART_STORAGE = 11;
  public static final int MINECART_POWERED = 12;
  public static final int ACTIVATED_TNT = 50;
  public static final int ENDER_CRYSTAL = 51;
  public static final int ARROW_PROJECTILE = 60;
  public static final int SNOWBALL_PROJECTILE = 61;
  public static final int EGG_PROJECTILE = 62;
  public static final int FIRE_BALL_GHAST = 63;
  public static final int FIRE_BALL_BLAZE = 64;
  public static final int THROWN_ENDERPEARL = 65;
  public static final int WITHER_SKULL = 66;
  public static final int FALLING_BLOCK = 70;
  public static final int ITEM_FRAME = 71;
  public static final int EYE_OF_ENDER = 72;
  public static final int THROWN_POTION = 73;
  public static final int FALLING_DRAGON_EGG = 74;
  public static final int THROWN_EXP_BOTTLE = 75;
  public static final int FISHING_FLOAT = 90;
  private static ObjectTypes INSTANCE = new ObjectTypes();
  
  public static ObjectTypes getInstance()
  {
    return INSTANCE;
  }
}

public WrapperPlayServerSpawnEntity()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerSpawnEntity(PacketContainer packet)
{
  super(packet, TYPE);
}

public WrapperPlayServerSpawnEntity(Entity entity, int type, int objectData)
{
  super(fromEntity(entity, type, objectData), TYPE);
}

private static PacketContainer fromEntity(Entity entity, int type, int objectData)
{
  if (entityConstructor == null) {
    entityConstructor = ProtocolLibrary.getProtocolManager().createPacketConstructor(TYPE, new Object[] { entity, Integer.valueOf(type), Integer.valueOf(objectData) });
  }
  return entityConstructor.createPacket(new Object[] { entity, Integer.valueOf(type), Integer.valueOf(objectData) });
}

public int getEntityID()
{
  return ((Integer)this.handle.getIntegers().read(0)).intValue();
}

public Entity getEntity(World world)
{
  return (Entity)this.handle.getEntityModifier(world).read(0);
}

public Entity getEntity(PacketEvent event)
{
  return getEntity(event.getPlayer().getWorld());
}

public void setEntityID(int value)
{
  this.handle.getIntegers().write(0, Integer.valueOf(value));
}

public int getType()
{
  return ((Integer)this.handle.getIntegers().read(9)).intValue();
}

public void setType(int value)
{
  this.handle.getIntegers().write(9, Integer.valueOf(value));
}

public double getX()
{
  return ((Integer)this.handle.getIntegers().read(1)).intValue() / 32.0D;
}

public void setX(double value)
{
  this.handle.getIntegers().write(1, Integer.valueOf((int)Math.floor(value * 32.0D)));
}

public double getY()
{
  return ((Integer)this.handle.getIntegers().read(2)).intValue() / 32.0D;
}

public void setY(double value)
{
  this.handle.getIntegers().write(2, Integer.valueOf((int)Math.floor(value * 32.0D)));
}

public double getZ()
{
  return ((Integer)this.handle.getIntegers().read(3)).intValue() / 32.0D;
}

public void setZ(double value)
{
  this.handle.getIntegers().write(3, Integer.valueOf((int)Math.floor(value * 32.0D)));
}

public double getOptionalSpeedX()
{
  return ((Integer)this.handle.getIntegers().read(4)).intValue() / 8000.0D;
}

public void setOptionalSpeedX(double value)
{
  this.handle.getIntegers().write(4, Integer.valueOf((int)(value * 8000.0D)));
}

public double getOptionalSpeedY()
{
  return ((Integer)this.handle.getIntegers().read(5)).intValue() / 8000.0D;
}

public void setOptionalSpeedY(double value)
{
  this.handle.getIntegers().write(5, Integer.valueOf((int)(value * 8000.0D)));
}

public double getOptionalSpeedZ()
{
  return ((Integer)this.handle.getIntegers().read(6)).intValue() / 8000.0D;
}

public void setOptionalSpeedZ(double value)
{
  this.handle.getIntegers().write(6, Integer.valueOf((int)(value * 8000.0D)));
}

public float getYaw()
{
  return ((Integer)this.handle.getIntegers().read(7)).intValue() * 360.0F / 256.0F;
}

public void setYaw(float value)
{
  this.handle.getIntegers().write(7, Integer.valueOf((int)(value * 256.0F / 360.0F)));
}

public float getPitch()
{
  return ((Integer)this.handle.getIntegers().read(8)).intValue() * 360.0F / 256.0F;
}

public void setPitch(float value)
{
  this.handle.getIntegers().write(8, Integer.valueOf((int)(value * 256.0F / 360.0F)));
}

public int getObjectData()
{
  return ((Integer)this.handle.getIntegers().read(10)).intValue();
}

public void setObjectData(int value)
{
  this.handle.getIntegers().write(10, Integer.valueOf(value));
}
}

