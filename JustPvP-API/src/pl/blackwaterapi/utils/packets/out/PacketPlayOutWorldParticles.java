package pl.blackwaterapi.utils.packets.out;

import org.bukkit.Location;

import pl.blackwaterapi.utils.Reflection;
import pl.blackwaterapi.utils.packets.Packet;
import pl.blackwaterapi.utils.packets.PacketType;

public class PacketPlayOutWorldParticles extends Packet
{
	public PacketPlayOutWorldParticles(ParticleType particle, Location loc, float xOffset, float yOffset, float zOffset, float speed, int amount)
	{
	  this.packet = constructor.invoke(new Object[] { particle.getName(), Float.valueOf((float)loc.getX()), Float.valueOf((float)loc.getY()), Float.valueOf((float)loc.getZ()), Float.valueOf(xOffset), Float.valueOf(yOffset), Float.valueOf(zOffset), Float.valueOf(speed), Integer.valueOf(amount) });
	}
	
	private static Class<?> packetClass = PacketType.PLAY_OUT_WORLD_PARTICLES.getPacket();
	private static Reflection.ConstructorInvoker constructor = Reflection.getConstructor(packetClass, new Class[] { String.class, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Integer.TYPE });
	
	public static enum ParticleType
	{
	  DRIP_WATER("dripWater"),  DRIP_LAVA("dripLava"),  SNOW_SHOVEL("snowshovel"),  MOB_SPELL("mobSpell"),  BUBBLE("bubble"),  SUSPEND("suspend"),  DEPTH_SUSPEND("depthSuspend"),  TOWN_AURA("townaura"),  CRIT("crit"),  SLIME("slime"),  HUGE_EXPLOSION("hugeexplosion"),  LARGE_EXPLODE("largeexplode"),  FIREWORKS_SPARK("fireworksSpark"),  HEART("heart"),  ANGRY_VILLAGER("angryVillager"),  MAGIC_CRIT("magicCrit"),  INSTANT_SPELL("instantSpell"),  WITCH_MAGIC("witchMagic"),  HAPPY_VILLAGER("happerVillager"),  NOTE("note"),  PORTAL("portal"),  ENCHANTMENT_TABLE("enchantmenttable"),  EXPLODE("explode"),  FLAME("flame"),  LAVA("lava"),  LARGE_SMOKE("largesmoke"),  CLOUD("cloud"),  RED_DUST("reddust"),  SNOWBALL_POOF("snowballpoof"),  MOB_SPELL_AMBIENT("mobSpellAmbient"),  SPELL("spell"),  FOOTSTEP("footstep"),  SPLASH("splash");
	  
	  private String name;
	  
	  private ParticleType(String name)
	  {
	    this.name = name;
	  }
	  
	  public String getName()
	  {
	    return this.name;
	  }
	}
}
