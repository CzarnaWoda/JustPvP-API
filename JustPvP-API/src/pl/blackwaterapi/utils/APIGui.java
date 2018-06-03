package pl.blackwaterapi.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

import pl.blackwaterapi.data.Config;

public class APIGui {
	
	public static InventoryView OpenMenu(Player p){
		Inventory inv = Bukkit.createInventory(p, 54,Util.fixColor(Config.API_GUI_NAME));
		
		return p.openInventory(inv);
	}

}
