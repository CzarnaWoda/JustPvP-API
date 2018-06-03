package pl.blackwaterapi.utils.packets.out;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import pl.blackwaterapi.utils.Reflection;
import pl.blackwaterapi.utils.packets.Packet;
import pl.blackwaterapi.utils.packets.PacketType;

public class PacketPlayOutBlockBreakAnimation extends Packet
{
	public PacketPlayOutBlockBreakAnimation(Player player, Block block, int damage)
	{
	  this.packet = constructor.invoke(new Object[] { Integer.valueOf(player.getEntityId()), Integer.valueOf(block.getX()), Integer.valueOf(block.getY()), Integer.valueOf(block.getZ()), Integer.valueOf(damage) });
	}
	
	private static Class<?> packetClass = PacketType.PLAY_OUT_BLOCK_BREAK_ANIMATION.getPacket();
	private static Reflection.ConstructorInvoker constructor = Reflection.getConstructor(packetClass, new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE });
}
