package pl.blackwaterapi.commands;

import org.bukkit.entity.Player;

public class APICommand extends PlayerCommand{

	public APICommand() {
		super("api", "glowna komenda API", "/api", "api.admin", new String [0]);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onCommand(Player p, String[] args) {
		
		return false;
	}

}
