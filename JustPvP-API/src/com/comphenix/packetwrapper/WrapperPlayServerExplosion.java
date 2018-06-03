package com.comphenix.packetwrapper;

import java.util.List;

import org.bukkit.util.Vector;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.ChunkPosition;

public class WrapperPlayServerExplosion
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.EXPLOSION;

public WrapperPlayServerExplosion()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerExplosion(PacketContainer packet)
{
  super(packet, TYPE);
}

public double getX()
{
  return ((Double)this.handle.getDoubles().read(0)).doubleValue();
}

public void setX(double value)
{
  this.handle.getDoubles().write(0, Double.valueOf(value));
}

public double getY()
{
  return ((Double)this.handle.getDoubles().read(1)).doubleValue();
}

public void setY(double value)
{
  this.handle.getDoubles().write(1, Double.valueOf(value));
}

public double getZ()
{
  return ((Double)this.handle.getDoubles().read(2)).doubleValue();
}

public void setZ(double value)
{
  this.handle.getDoubles().write(2, Double.valueOf(value));
}

public float getRadius()
{
  return ((Float)this.handle.getFloat().read(0)).floatValue();
}

public void setRadius(float value)
{
  this.handle.getFloat().write(0, Float.valueOf(value));
}

@SuppressWarnings({ "unchecked", "rawtypes" })
public List<ChunkPosition> getRecords()
{
  return (List)this.handle.getPositionCollectionModifier().read(0);
}

public void setRecords(List<ChunkPosition> value)
{
  this.handle.getPositionCollectionModifier().write(0, value);
}

public float getPlayerMotionX()
{
  return ((Float)this.handle.getFloat().read(0)).floatValue();
}

public void setPlayerMotionX(float value)
{
  this.handle.getFloat().write(0, Float.valueOf(value));
}

public float getPlayerMotionY()
{
  return ((Float)this.handle.getFloat().read(1)).floatValue();
}

public void setPlayerMotionY(float value)
{
  this.handle.getFloat().write(1, Float.valueOf(value));
}

public float getPlayerMotionZ()
{
  return ((Float)this.handle.getFloat().read(2)).floatValue();
}

public void setPlayerMotionZ(float value)
{
  this.handle.getFloat().write(2, Float.valueOf(value));
}

public Vector getPlayerMotion()
{
  return new Vector(getPlayerMotionX(), getPlayerMotionY(), getPlayerMotionZ());
}

public void setPlayerMotion(Vector motion)
{
  setPlayerMotionX((float)motion.getX());
  setPlayerMotionY((float)motion.getY());
  setPlayerMotionZ((float)motion.getZ());
}
}
