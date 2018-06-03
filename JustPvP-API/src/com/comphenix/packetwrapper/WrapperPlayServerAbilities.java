package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayServerAbilities
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Play.Server.ABILITIES;

public WrapperPlayServerAbilities()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperPlayServerAbilities(PacketContainer packet)
{
  super(packet, TYPE);
}

public boolean isCreativeMode()
{
  return ((Boolean)this.handle.getSpecificModifier(Boolean.TYPE).read(0)).booleanValue();
}

public void setCreativeMode(boolean value)
{
  this.handle.getSpecificModifier(Boolean.TYPE).write(0, Boolean.valueOf(value));
}

public boolean isFlying()
{
  return ((Boolean)this.handle.getSpecificModifier(Boolean.TYPE).read(1)).booleanValue();
}

public void setFlying(boolean value)
{
  this.handle.getSpecificModifier(Boolean.TYPE).write(1, Boolean.valueOf(value));
}

public boolean isFlyingAllowed()
{
  return ((Boolean)this.handle.getSpecificModifier(Boolean.TYPE).read(2)).booleanValue();
}

public void setFlyingAllowed(boolean value)
{
  this.handle.getSpecificModifier(Boolean.TYPE).write(2, Boolean.valueOf(value));
}

public boolean isGodMode()
{
  return ((Boolean)this.handle.getSpecificModifier(Boolean.TYPE).read(3)).booleanValue();
}

public void setGodMode(boolean value)
{
  this.handle.getSpecificModifier(Boolean.TYPE).write(3, Boolean.valueOf(value));
}

public float getFlyingSpeed()
{
  return ((Float)this.handle.getFloat().read(0)).floatValue();
}

public void setFlyingSpeed(float value)
{
  this.handle.getFloat().write(0, Float.valueOf(value));
}

public float getWalkingSpeed()
{
  return ((Float)this.handle.getFloat().read(1)).floatValue();
}

public void setWalkingSpeed(float value)
{
  this.handle.getFloat().write(1, Float.valueOf(value));
}
}
