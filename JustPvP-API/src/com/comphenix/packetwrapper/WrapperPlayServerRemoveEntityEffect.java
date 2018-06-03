package com.comphenix.packetwrapper;

import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.potion.PotionEffectType;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

public class WrapperPlayServerRemoveEntityEffect
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.REMOVE_ENTITY_EFFECT;

public WrapperPlayServerRemoveEntityEffect()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerRemoveEntityEffect(PacketContainer packet)
{
  super(packet, TYPE);
}

public int getEntityId()
{
  return ((Integer)this.handle.getIntegers().read(0)).intValue();
}

public void setEntityId(int value)
{
  this.handle.getIntegers().write(0, Integer.valueOf(value));
}

public Entity getEntity(World world)
{
  return (Entity)this.handle.getEntityModifier(world).read(0);
}

public Entity getEntity(PacketEvent event)
{
  return getEntity(event.getPlayer().getWorld());
}

public byte getEffectId()
{
  return ((Byte)this.handle.getBytes().read(1)).byteValue();
}

public void setEffectId(byte value)
{
  this.handle.getBytes().write(1, Byte.valueOf(value));
}
@SuppressWarnings("deprecation")
public PotionEffectType getEffect()
{
  return PotionEffectType.getById(getEffectId());
}
@SuppressWarnings("deprecation")
public void setEffect(PotionEffectType value)
{
  setEffectId((byte)value.getId());
}
}

