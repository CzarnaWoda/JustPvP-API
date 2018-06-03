package com.comphenix.packetwrapper;

import org.bukkit.World;
import org.bukkit.entity.Entity;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

public class WrapperPlayServerEntityStatus
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.ENTITY_STATUS;

public static class Status
{
  public static final int ENTITY_HURT = 2;
  public static final int ENTITY_DEAD = 3;
  public static final int WOLF_TAMING = 6;
  public static final int WOLF_TAMED = 7;
  public static final int WOLF_SHAKING_OFF_WATER = 8;
  public static final int EATING_ACCEPTED = 9;
  public static final int SHEEP_EATING_GRASS = 10;
  public static final int IRON_GOLEM_GIFTING_ROSE = 11;
  public static final int VILLAGER_SPAWN_HEART_PARTICLE = 12;
  public static final int VILLAGER_SPAWN_ANGRY_PARTICLE = 13;
  public static final int VILLAGER_SPAWN_HAPPY_PARTICLE = 14;
  public static final int WITCH_SPAWN_MAGIC_PARTICLE = 15;
  public static final int ZOMBIE_VILLAGERIZING = 16;
  public static final int FIREWORK_EXPLODING = 17;
  private static Status INSTANCE = new Status();
  
  public static Status getInstance()
  {
    return INSTANCE;
  }
}

public WrapperPlayServerEntityStatus()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerEntityStatus(PacketContainer packet)
{
  super(packet, TYPE);
}

public int getEntityId()
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

public void setEntityId(int value)
{
  this.handle.getIntegers().write(0, Integer.valueOf(value));
}

public int getEntityStatus()
{
  return ((Byte)this.handle.getBytes().read(0)).intValue();
}

public void setEntityStatus(int value)
{
  this.handle.getBytes().write(0, Byte.valueOf((byte)value));
}
}

