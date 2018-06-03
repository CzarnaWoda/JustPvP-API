package pl.blackwaterapi.utils.packets;

import pl.blackwaterapi.utils.Reflection;

public enum PacketType
{
  PLAY_OUT_SCOREBOARD_TEAM("PacketPlayOutScoreboardTeam"),  PLAY_OUT_PLAYER_INFO("PacketPlayOutPlayerInfo"),  PLAY_OUT_WORLD_PARTICLES("PacketPlayOutWorldParticles"),  PLAY_OUT_BLOCK_BREAK_ANIMATION("PacketPlayOutBlockBreakAnimation");
  
  private String className;
  
  private PacketType(String name)
  {
    this.className = name;
  }
  
  public Class<?> getPacket()
  {
    return Reflection.getMinecraftClass(this.className);
  }
  
  public String getClassName()
  {
    return this.className;
  }
}
