package pl.blackwaterapi.utils.packets.out;

import java.util.Arrays;

import pl.blackwaterapi.utils.Reflection;
import pl.blackwaterapi.utils.packets.Packet;
import pl.blackwaterapi.utils.packets.PacketType;

public class PacketPlayOutScoreboardTeam extends Packet{
	public PacketPlayOutScoreboardTeam(String name, String display, String prefix, String suffix, int flag, String... members)
	{
	  this.packet = constructor.invoke(new Object[0]);
	  setValue("a", name.length() > 16 ? name.substring(0, 16) : name);
	  setValue("f", Integer.valueOf(flag));
	  if ((flag == 0) || (flag == 2))
	  {
	    setValue("b", display == null ? "" : display.substring(0, Math.min(display.length(), 16)));
	    setValue("c", prefix == null ? "" : prefix.substring(0, Math.min(prefix.length(), 16)));
	    setValue("d", suffix == null ? "" : suffix.substring(0, Math.min(suffix.length(), 16)));
	    setValue("g", Integer.valueOf(0));
	    if (flag == 0) {
	      setValue("e", Arrays.asList(members));
	    }
	  }
	  else if ((flag == 3) || (flag == 4))
	  {
	    setValue("g", Integer.valueOf(0));
	    setValue("e", Arrays.asList(members));
	  }
	}
	
	private static Class<?> packetClass = PacketType.PLAY_OUT_SCOREBOARD_TEAM.getPacket();
	private static Reflection.ConstructorInvoker constructor = Reflection.getConstructor(packetClass, (Class[])new Class[0]);
}
