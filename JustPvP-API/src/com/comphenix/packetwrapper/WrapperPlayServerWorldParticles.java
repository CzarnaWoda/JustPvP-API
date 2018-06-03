package com.comphenix.packetwrapper;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

public class WrapperPlayServerWorldParticles
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.WORLD_PARTICLES;

public static enum ParticleEffect
{
  HUGE_EXPLOSION("hugeexplosion"),  LARGE_EXPLODE("largeexplode"),  FIREWORKS_SPARK("fireworksSpark"),  BUBBLE("bubble"),  SUSPEND("suspend"),  DEPTH_SUSPEND("depthSuspend"),  TOWN_AURA("townaura"),  CRIT("crit"),  MAGIC_CRIT("magicCrit"),  MOB_SPELL("mobSpell"),  MOB_SPELL_AMBIENT("mobSpellAmbient"),  SPELL("spell"),  INSTANT_SPELL("instantSpell"),  WITCH_MAGIC("witchMagic"),  NOTE("note"),  PORTAL("portal"),  ENCHANTMENT_TABLE("enchantmenttable"),  EXPLODE("explode"),  FLAME("flame"),  LAVA("lava"),  FOOTSTEP("footstep"),  SPLASH("splash"),  LARGE_SMOKE("largesmoke"),  CLOUD("cloud"),  RED_DUST("reddust"),  SNOWBALL_POOF("snowballpoof"),  DRIP_WATER("dripWater"),  DRIP_LAVA("dripLava"),  SNOW_SHOVEL("snowshovel"),  SLIME("slime"),  HEART("heart"),  ANGRY_VILLAGER("angryVillager"),  HAPPY_VILLAGER("happerVillager"),  ICONCRACK("iconcrack_"),  TILECRACK("tilecrack_");
  
  private final String name;
  private static volatile Map<String, ParticleEffect> LOOKUP = generateLookup();
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
private static Map<String, ParticleEffect> generateLookup()
  {
    Map<String, ParticleEffect> created = new HashMap();
    for (ParticleEffect effect : values()) {
      created.put(effect.getParticleName(), effect);
    }
    return created;
  }
  
  private ParticleEffect(String name)
  {
    this.name = name;
  }
  
  public static ParticleEffect fromName(String name)
  {
    return (ParticleEffect)LOOKUP.get(name);
  }
  
  public String getParticleName()
  {
    return this.name;
  }
}

public WrapperPlayServerWorldParticles()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerWorldParticles(PacketContainer packet)
{
  super(packet, TYPE);
}

public WrapperPlayServerWorldParticles(ParticleEffect effect, int count, Location location, Vector offset)
{
  this();
  setParticleEffect(effect);
  setNumberOfParticles(count);
  setLocation(location);
  setOffset(offset);
}

public String getParticleName()
{
  return (String)this.handle.getStrings().read(0);
}

public void setParticleName(String value)
{
  this.handle.getStrings().write(0, value);
}

public ParticleEffect getParticleEffect()
{
  return ParticleEffect.fromName(getParticleName());
}

public void setParticleEffect(ParticleEffect effect)
{
  if (effect == null) {
    throw new IllegalArgumentException("effect cannot be NULL.");
  }
  setParticleName(effect.getParticleName());
}

public Location getLocation(PacketEvent event)
{
  return getLocation(event.getPlayer().getWorld());
}

public Location getLocation(World world)
{
  return new Location(world, getX(), getY(), getZ());
}

public void setLocation(Location loc)
{
  if (loc == null) {
    throw new IllegalArgumentException("Location cannot be NULL.");
  }
  setX((float)loc.getX());
  setY((float)loc.getY());
  setZ((float)loc.getZ());
}

public void setOffset(Vector vector)
{
  if (vector == null) {
    throw new IllegalArgumentException("Vector cannot be NULL.");
  }
  setOffsetX((float)vector.getX());
  setOffsetY((float)vector.getY());
  setOffsetZ((float)vector.getZ());
}

public Vector getOffset()
{
  return new Vector(getX(), getY(), getZ());
}

public float getX()
{
  return ((Float)this.handle.getFloat().read(0)).floatValue();
}

public void setX(float value)
{
  this.handle.getFloat().write(0, Float.valueOf(value));
}

public float getY()
{
  return ((Float)this.handle.getFloat().read(1)).floatValue();
}

public void setY(float value)
{
  this.handle.getFloat().write(1, Float.valueOf(value));
}

public float getZ()
{
  return ((Float)this.handle.getFloat().read(2)).floatValue();
}

public void setZ(float value)
{
  this.handle.getFloat().write(2, Float.valueOf(value));
}

public float getOffsetX()
{
  return ((Float)this.handle.getFloat().read(3)).floatValue();
}

public void setOffsetX(float value)
{
  this.handle.getFloat().write(3, Float.valueOf(value));
}

public float getOffsetY()
{
  return ((Float)this.handle.getFloat().read(4)).floatValue();
}

public void setOffsetY(float value)
{
  this.handle.getFloat().write(4, Float.valueOf(value));
}

public float getOffsetZ()
{
  return ((Float)this.handle.getFloat().read(5)).floatValue();
}

public void setOffsetZ(float value)
{
  this.handle.getFloat().write(5, Float.valueOf(value));
}

public float getParticleSpeed()
{
  return ((Float)this.handle.getFloat().read(6)).floatValue();
}

public void setParticleSpeed(float value)
{
  this.handle.getFloat().write(6, Float.valueOf(value));
}

public int getNumberOfParticles()
{
  return ((Integer)this.handle.getIntegers().read(0)).intValue();
}

public void setNumberOfParticles(int value)
{
  this.handle.getIntegers().write(0, Integer.valueOf(value));
}
}
