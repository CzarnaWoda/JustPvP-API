package pl.blackwaterapi.timer;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.blackwaterapi.utils.Util;

public class TimerUtil
{
    public static void teleport(Player p, Location location, int delay) {
        if (!p.hasPermission("api.timer.bypass")) {
            Util.sendMsg((CommandSender)p, "&6Teleport nastapi za &c" + Util.secondsToString(delay) + "&6!");
        }
        TimerManager.addTask(p, new TimerCallback<Player>() {
            @SuppressWarnings("deprecation")
			@Override
            public void success(Player player) {
                player.teleport(location);
                Util.sendMsg((CommandSender)player, "&6Przeteleportowano!");
            	Location loc = player.getLocation();
            	player.getWorld().refreshChunk(loc.getBlockX(), loc.getBlockZ());
            }
            
            @Override
            public void error(Player player) {
                Util.sendMsg((CommandSender)player, "&4Blad: &cTeleport zostal przerwany!");
            }
        }, delay);
    }
}
