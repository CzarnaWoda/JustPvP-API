package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperPlayClientFlying extends AbstractPacket
{
    public static final PacketType TYPE;
    
    public WrapperPlayClientFlying() {
        super(new PacketContainer(WrapperPlayClientFlying.TYPE), WrapperPlayClientFlying.TYPE);
        this.handle.getModifier().writeDefaults();
    }
    
    public WrapperPlayClientFlying(final PacketContainer packet) {
        super(packet, WrapperPlayClientFlying.TYPE);
    }
    
    protected WrapperPlayClientFlying(final PacketContainer packet, final PacketType type) {
        super(packet, type);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean getOnGround() {
        return (boolean)this.handle.getSpecificModifier((Class)Boolean.TYPE).read(0);
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void setOnGround(final boolean value) {
        this.handle.getSpecificModifier((Class)Boolean.TYPE).write(0, (Object)value);
    }
    
    static {
        TYPE = PacketType.Play.Client.FLYING;
    }
}
