package com.comphenix.packetwrapper;

import java.security.PublicKey;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperLoginServerEncryptionBegin
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Login.Server.ENCRYPTION_BEGIN;

public WrapperLoginServerEncryptionBegin()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperLoginServerEncryptionBegin(PacketContainer packet)
{
  super(packet, TYPE);
}

public String getServerId()
{
  return (String)this.handle.getStrings().read(0);
}

public void setServerId(String value)
{
  this.handle.getStrings().write(0, value);
}

public PublicKey getPublicKey()
{
  return (PublicKey)this.handle.getSpecificModifier(PublicKey.class).read(0);
}

public void setPublicKey(PublicKey value)
{
  this.handle.getSpecificModifier(PublicKey.class).write(0, value);
}

public byte[] getVerifyToken()
{
  return (byte[])this.handle.getByteArrays().read(0);
}

public void getVerifyToken(byte[] value)
{
  this.handle.getByteArrays().write(0, value);
}
}
