package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperLoginClientEncryptionBegin
extends AbstractPacket
{
public static final PacketType TYPE = PacketType.Login.Client.ENCRYPTION_BEGIN;

public WrapperLoginClientEncryptionBegin()
{
  super(new PacketContainer(TYPE), TYPE);
  this.handle.getModifier().writeDefaults();
}

public WrapperLoginClientEncryptionBegin(PacketContainer packet)
{
  super(packet, TYPE);
}

public byte[] getSharedSecret()
{
  return (byte[])this.handle.getByteArrays().read(0);
}

public void getSharedSecret(byte[] value)
{
  this.handle.getByteArrays().write(0, value);
}

public byte[] getVerifyTokenResponse()
{
  return (byte[])this.handle.getByteArrays().read(1);
}

public void setVerifyTokenResponse(byte[] value)
{
  this.handle.getByteArrays().write(1, value);
}
}
