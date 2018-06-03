package pl.blackwaterapi.utils.packets;

import org.bukkit.entity.Player;

import pl.blackwaterapi.utils.PacketUtil;
import pl.blackwaterapi.utils.Reflection;

public abstract class Packet
{
    protected Object packet;
    
    public void send(Player player) {
        if (this.packet == null) {
            throw new IllegalArgumentException("Packet cannot be null!");
        }
        PacketUtil.sendPacket(player, this.packet);
    }
    
    public void setValue(String fieldName, Object value) {
        if (this.packet == null) {
            throw new IllegalArgumentException("Packet cannot be null!");
        }
        Reflection.getSimpleField(this.packet.getClass(), fieldName).set(this.packet, value);
    }
    
    public Object getValue(String fieldName) {
        if (this.packet == null) {
            throw new IllegalArgumentException("Packet cannot be null!");
        }
        return Reflection.getSimpleField(this.packet.getClass(), fieldName).get(this.packet);
    }
    
    public Object getPacket() {
        return this.packet;
    }
    
    public void setPacket(Object packet) {
        this.packet = packet;
    }
}
