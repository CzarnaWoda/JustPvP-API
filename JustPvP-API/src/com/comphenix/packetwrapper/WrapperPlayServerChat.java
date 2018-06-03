package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedChatComponent;


public class WrapperPlayServerChat
  extends AbstractPacket
{
  public static final PacketType TYPE = PacketType.Play.Server.CHAT;
  
  public WrapperPlayServerChat()
  {
    super(new PacketContainer(TYPE), TYPE);
    this.handle.getModifier().writeDefaults();
  }
  
  public WrapperPlayServerChat(PacketContainer packet)
  {
    super(packet, TYPE);
  }
  
  public WrappedChatComponent getMessage()
  {
    return (WrappedChatComponent)this.handle.getChatComponents().read(0);
  }
  
  public void setMessage(WrappedChatComponent value)
  {
    this.handle.getChatComponents().write(0, value);
  }
}
