package pl.blackwaterapi.utils.packets.out;

import pl.blackwaterapi.utils.Logger;
import pl.blackwaterapi.utils.PacketUtil;
import pl.blackwaterapi.utils.Reflection;
import pl.blackwaterapi.utils.packets.Packet;
import pl.blackwaterapi.utils.packets.PacketType;

public class PacketPlayOutPlayerInfo extends Packet{
	public PacketPlayOutPlayerInfo(String name, boolean visible, int ping)
	{
	  if (type == 0) {
	    this.packet = constructor.invoke(new Object[] { name, Boolean.valueOf(visible), Integer.valueOf(ping) });
	  } else {
	    try
	    {
	      this.packet = packetClass.newInstance();
	      int action = visible ? 0 : 4;
	      setValue("action", Integer.valueOf(action));
	      setValue("player", PacketUtil.getGameProfile(name));
	      setValue("gamemode", Integer.valueOf(0));
	      setValue("ping", Integer.valueOf(ping));
	      setValue("username", name);
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	    }
	  }
	}
	
	protected static int type = 0;
	private static Class<?> packetClass;
	private static Reflection.ConstructorInvoker constructor;
	
	static
	{
	  try
	  {
	    packetClass = PacketType.PLAY_OUT_PLAYER_INFO.getPacket();
	    constructor = Reflection.getConstructor(packetClass, new Class[] { String.class, Boolean.TYPE, Integer.TYPE });
	  }
	  catch (Exception e)
	  {
	    Logger.warning(new String[] { "Are you using spigot 1.8? :>" });
	    type = 1;
	  }
	}
}