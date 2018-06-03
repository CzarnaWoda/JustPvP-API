package pl.blackwaterapi;


import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import pl.blackwaterapi.commands.Command;
import pl.blackwaterapi.commands.CommandManager;
import pl.blackwaterapi.configs.ConfigManager;
import pl.blackwaterapi.data.Config;
import pl.blackwaterapi.sockets.SocketTask;
import pl.blackwaterapi.store.Store;
import pl.blackwaterapi.store.StoreMode;
import pl.blackwaterapi.store.modes.StoreMySQL;
import pl.blackwaterapi.store.modes.StoreSQLITE;
import pl.blackwaterapi.timer.TimerManager;
import pl.blackwaterapi.utils.Logger;
import pl.blackwaterapi.utils.Ticking;

public class API extends JavaPlugin
{
    @SuppressWarnings("unused")
	private static CommandMap cmdMap;
    private static API plugin;
    private static Store store;
    private static PluginManager pluginManager;
    private static SocketTask socketTask;
    public static API instance;
    public static boolean works = true;
    public static String nmsver;
    public static boolean useOldMethods = false;
    public void onLoad()
    {
      plugin = this;
    }
    
    public void onEnable() {
        nmsver = Bukkit.getServer().getClass().getPackage().getName();
        nmsver = nmsver.substring(nmsver.lastIndexOf(".") + 1);

        if (nmsver.equalsIgnoreCase("v1_8_R1") || nmsver.startsWith("v1_7_")) { // Not sure if 1_7 works for the protocol hack?
            useOldMethods = true;
        }
        new Ticking().start();
        Config.reloadConfig();
        this.registerDatabase();
        registerListener((Plugin)this, new TimerManager());
    }
    
    public void onDisable() {
        try {
            Thread.sleep(2000L);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (API.store != null && API.store.isConnected()) {
            API.store.disconnect();
        }
    }
    protected boolean registerDatabase() {
        switch (StoreMode.getByName(Config.DATABASE_MODE)) {
            case MYSQL: {
                API.store = new StoreMySQL(Config.DATABASE_MYSQL_HOST, Config.DATABASE_MYSQL_PORT, Config.DATABASE_MYSQL_USER, Config.DATABASE_MYSQL_PASS, Config.DATABASE_MYSQL_NAME, Config.DATABASE_TABLEPREFIX);
                break;
            }
            case SQLITE: {
                API.store = new StoreSQLITE(Config.DATABASE_SQLITE_NAME, Config.DATABASE_TABLEPREFIX);
                break;
            }
            default: {
                Logger.warning("Value of databse mode is not valid! Using SQLITE as database!");
                API.store = new StoreSQLITE(Config.DATABASE_SQLITE_NAME, Config.DATABASE_TABLEPREFIX);
                break;
            }
        }
        boolean conn = API.store.connect();
        if (conn) {
        	if(Config.DATABASE_SERVER_TYPE.equalsIgnoreCase("chestpvp")){
        	store.update(true, "CREATE TABLE IF NOT EXISTS `{P}warp` (" + (store.getStoreMode() == StoreMode.MYSQL ? "`id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," : "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,") +
        				"`name` varchar(32) NOT NULL,`location` text NOT NULL, `pex` varchar(32) NOT NULL NOT NULL);");
        	store.update(true, "CREATE TABLE IF NOT EXISTS `{P}youtube` (" + (store.getStoreMode() == StoreMode.MYSQL ? "`id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," : "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,") 
        				+ "`name` varchar(32) NOT NULL,`channel` varchar(128) NOT NULL, `reklama` varchar(128) NOT NULL, `subs` int(10) NOT NULL NOT NULL);");
        	store.update(true, "CREATE TABLE IF NOT EXISTS `{P}users` (" + ((store.getStoreMode() == StoreMode.MYSQL) ? "`id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," : "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,") + 
        				" `uuid` varchar(255) NOT NULL, `lastName` varchar(16) NOT NULL,`gamemode` int(1) NOT NULL,`fly` int(1) NOT NULL,"
        					+ "`god` int(1) NOT NULL,`lastWorld` varchar(32) NOT NULL,`lastX` int(10) NOT NULL,`lastY` int(10) NOT NULL,`lastZ` int(10) NOT NULL,`homeWorld` varchar(32)"
        					+ " NOT NULL,`homeX` int(10) NOT NULL,`homeY` int(10) NOT NULL,`homeZ` int(10) NOT NULL,`kills` int(10) NOT NULL,`deaths` int(10) NOT NULL,`logouts` int(10)"
        					+ " NOT NULL,`coins` int(10) NOT NULL,`limitk` int(10) NOT NULL,`limitp` int(10) NOT NULL,`limitr` int(10) NOT NULL,`koxpvp` int(10) NOT NULL,`timePlay` "
        					+ "int(10) NOT NULL,`killstattrack` int(10) NOT NULL,`killstreak` int(10) NOT NULL,`money` int(10) NOT NULL,`koxeat` int(10) NOT NULL,`ref` int(10) NOT NULL,"
        					+ "`perly` int(10) NOT NULL,`open` int(10) NOT NULL,`chestplace` int(10) NOT NULL,`firstKill` varchar(16) NOT NULL,`firstIp` varchar(32) NOT NULL,`lastIp`"
        					+ " varchar(32) NOT NULL,`lastJoin` varchar(32) NOT NULL,`KitVIPTime` bigint(20) NOT NULL,`kitSVIPTime` bigint(20) NOT NULL,`KitJEDZENIETime` bigint(20) NOT NULL"
        					+ ",`dodatkowemoney` int(10) NOT NULL,`dodatkowelvl` int(10) NOT NULL,`koxboost` int(10) NOT NULL,`refboost` int(10) NOT NULL,`chestboost` int(10) NOT NULL,`mute`"
        					+ " bigint(20) NOT NULL,`muteReason` varchar(16) NOT NULL,`expireTime` bigint(20) NOT NULL,`turbomoney` int(10) NOT NULL,`koxschowek` int(10) NOT NULL,`refschowek`"
        					+ " int(10) NOT NULL,`pearlschowek` int(10) NOT NULL,`exp` float NOT NULL,`level` int(10) NOT NULL,`breakStoneday` int(64) NOT NULL,`minestonelimit` int(32) NOT NULL,`KitMVIPTime` bigint(20) NOT NULL NOT NULL);");
        	store.update(true, "CREATE TABLE IF NOT EXISTS `{P}alliances` (" + (store.getStoreMode() == StoreMode.MYSQL ? "`id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," : "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,") + 
        				"`guild_1` varchar(255) NOT NULL,`guild_2` varchar(255) NOT NULL NOT NULL);");
        	store.update(true, "CREATE TABLE IF NOT EXISTS `{P}bans` (" + (store.getStoreMode() == StoreMode.MYSQL ? "`id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," : "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,") + 
        				" `uuid` varchar(255) NOT NULL,`reason` varchar(255) NOT NULL,`admin` varchar(255) NOT NULL,`createtime` bigint(22) NOT NULL,`expiretime` bigint(22) NOT NULL,`unban` int(1) NOT NULL NOT NULL);");
        	store.update(true, "CREATE TABLE IF NOT EXISTS `{P}guilds` (" + ((store.getStoreMode() == StoreMode.MYSQL) ? "`id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," : "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,") +
        				"`tag` varchar(255) NOT NULL,`name` varchar(255) NOT NULL,`owner` varchar(255) NOT NULL,`leader` varchar(255) NOT NULL,`createTime` bigint(22) NOT NULL,"
        				+ "`pvp` int(1) NOT NULL DEFAULT '0',`playersLimit` int(11) NOT NULL,`expireTime` bigint(22) NOT NULL,`turbodrop` int(11) NOT NULL,`turbodropexpireTime`"
        				+ " bigint(22) NOT NULL,`guildkills` int(11) NOT NULL,`points` int(24) NOT NULL NOT NULL);");
        	store.update(true, "CREATE TABLE IF NOT EXISTS `{P}ipbans` (" + ((store.getStoreMode() == StoreMode.MYSQL) ? "`id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," : "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,") +
        				" `ip` varchar(32) NOT NULL,`reason` varchar(255) NOT NULL,`admin` varchar(255) NOT NULL,`createtime` bigint(22) NOT NULL,`expiretime` "
        				+ "bigint(22) NOT NULL,`unban` int(1) NOT NULL NOT NULL);");
        	store.update(true, "CREATE TABLE IF NOT EXISTS `{P}members` (" + ((store.getStoreMode() == StoreMode.MYSQL) ? "`id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," : "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,") +
        				" `uuid` varchar(36) NOT NULL,`name` varchar(255) NOT NULL,`tag` varchar(255) NOT NULL NOT NULL);");
        	store.update(true, "CREATE TABLE IF NOT EXISTS `{P}whitelisted` (" + ((store.getStoreMode() == StoreMode.MYSQL) ? "`id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," : "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,") +
        				" `uuid` varchar(255) NOT NULL NOT NULL);");
        	store.update(true, "CREATE TABLE IF NOT EXISTS `{P}blacklist` (" + ((store.getStoreMode() == StoreMode.MYSQL) ? "`id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," : "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,") +
        				" `name` varchar(255) NOT NULL, `admin` varchar(255) NOT NULL, `ip` varchar(255) NOT NULL NOT NULL);");
        	store.update(true, "CREATE TABLE IF NOT EXISTS `{P}timeranks` (" + ((store.getStoreMode() == StoreMode.MYSQL) ? "`id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," : "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,") +
        				" `lastname` varchar(255) NOT NULL, `rank` varchar(255) NOT NULL, `previousrank` varchar(255) NOT NULL, `expiretime` bigint(20) NOT NULL NOT NULL);");
        	store.update(true, "CREATE TABLE IF NOT EXISTS `{P}mine` (" + (store.getStoreMode() == StoreMode.MYSQL ? "`id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," : "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,") +
        				"`index` int(16) NOT NULL,`name` varchar(64) NOT NULL,`type` varchar(6) NOT NULL,`cost` int(16) NOT NULL,`location` text NOT NULL,`level` int(16) NOT NULL,`mainRegion` varchar(32) NOT NULL,`stoneRegion` varchar(32) NOT NULL,`minestonelimit` int(16) NOT NULL,`guild` varchar(32) NOT NULL NOT NULL);");
        	store.update(true, "CREATE TABLE IF NOT EXISTS `{P}drop` (" + (store.getStoreMode() == StoreMode.MYSQL ? "`id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," : "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,") +
        				"`uuid` varchar(255) NOT NULL,`lastName` varchar(32) NOT NULL, `expireTime` bigint(13),`turbodrop` int(10) NOT NULL,`bonusdrop` int(10) NOT NULL,`lvl` int(10) NOT NULL,"
        				+ "`exp` int(10) NOT NULL,`diamenty` int(10) NOT NULL,`szmaragdy` int(10) NOT NULL,`zloto` int(10) NOT NULL,`zelazo` int(10) NOT NULL,`piasek` int(10) NOT NULL,`wegiel` int(10) NOT NULL,"
        				+ "`redstone` int(10) NOT NULL,`lapis` int(10) NOT NULL,`proch` int(10) NOT NULL,`perly` int(10) NOT NULL,`slimeball` int(10) NOT NULL,`jablka` int(10) NOT NULL,`ksiazki` int(10) NOT NULL,"
        				+ "`skrzynki` int(10) NOT NULL,`coinsy` int(10) NOT NULL,`cobble` int(10) NOT NULL, `expireTimeExp` bigint(13),`turboexp` int(10) NOT NULL NOT NULL);");
            return conn;
        }else if (Config.DATABASE_SERVER_TYPE.equalsIgnoreCase("hc")){
        	store.update(true, "CREATE TABLE IF NOT EXISTS `{P}whitelisted` (" + ((store.getStoreMode() == StoreMode.MYSQL) ? "`id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," : "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,") +
        				" `uuid` varchar(255) NOT NULL NOT NULL);");
        	store.update(true, "CREATE TABLE IF NOT EXISTS `{P}users` (" + ((store.getStoreMode() == StoreMode.MYSQL) ? "`id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," : "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,") + 
        				"`uuid` varchar(255) NOT NULL, `lastName` varchar(16) NOT NULL,`gameMode` int(1) NOT NULL,`fly` int(1) NOT NULL,"
        					+ "`god` int(1) NOT NULL,`points` int(16) NOT NULL,`kills` int(10) NOT NULL,`deaths` int(10) NOT NULL,`logouts` int(10) NOT NULL,`assists` int(10) NOT NULL,`lastWorld` varchar(32)"
        					+ " NOT NULL,`lastX` int(10) NOT NULL,`lastY` int(10) NOT NULL,`lastZ` int(10) NOT NULL,`homeWorld` varchar(32) NOT NULL,`homeX` int(10) NOT NULL,`homeY` int(10)"
        					+ " NOT NULL,`homeZ` int(10) NOT NULL,`firstIp` varchar(32) NOT NULL,`lastIp` varchar(32) NOT NULL,`lastJoin` varchar(32) NOT NULL,`timePlay` int(10) NOT NULL,`kitVIPTime` "
        					+ "bigint(20) NOT NULL,`kitGRACZTime` bigint(20) NOT NULL,`kitJEDZENIETime` bigint(20) NOT NULL,`mute` bigint(20) NOT NULL,`muteReason` varchar(255) NOT NULL,`lastKill` varchar(32),`lastKillTime` bigint(20) NOT NULL"
        					+ ",`guildCaninvite` int(1) NOT NULL,`guildCanopen` int(1) NOT NULL,`guildCanbreak` int(1) NOT NULL,`guildCanpvp` int(1) NOT NULL,`schowekrefil` int(32) NOT NULL,`schowekkox` int(32) NOT NULL,"
        					+ "`schowekpearl` int(32) NOT NULL,`koxeatamount` int(16) NOT NULL NOT NULL);");
        	store.update(true, "CREATE TABLE IF NOT EXISTS `{P}bans` (" + (store.getStoreMode() == StoreMode.MYSQL ? "`id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," : "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,") + 
        				" `uuid` varchar(255) NOT NULL,`reason` varchar(255) NOT NULL,`admin` varchar(255) NOT NULL,`createtime` bigint(22) NOT NULL,`expiretime` bigint(22) NOT NULL,`unban` int(1) NOT NULL NOT NULL);");
        	store.update(true, "CREATE TABLE IF NOT EXISTS `{P}ipbans` (" + ((store.getStoreMode() == StoreMode.MYSQL) ? "`id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," : "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,") +
        				" `ip` varchar(32) NOT NULL,`reason` varchar(255) NOT NULL,`admin` varchar(255) NOT NULL,`createtime` bigint(22) NOT NULL,`expiretime` "
        				+ "bigint(22) NOT NULL,`unban` int(1) NOT NULL NOT NULL);");
        	store.update(true, "CREATE TABLE IF NOT EXISTS `{P}warp` (" + (store.getStoreMode() == StoreMode.MYSQL ? "`id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," : "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,") +
        				"`name` varchar(32) NOT NULL,`location` text NOT NULL, `pex` varchar(32) NOT NULL NOT NULL);");
        	store.update(true, "CREATE TABLE IF NOT EXISTS `{P}drop` (" + (store.getStoreMode() == StoreMode.MYSQL ? "`id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," : "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,") +
        				"`uuid` varchar(255) NOT NULL,`lastName` varchar(32) NOT NULL, `expireTime` bigint(13),`turbodrop` int(10) NOT NULL,`bonusdrop` int(10) NOT NULL,`lvl` int(10) NOT NULL,"
        				+ "`exp` int(10) NOT NULL,`diamenty` int(10) NOT NULL,`szmaragdy` int(10) NOT NULL,`zloto` int(10) NOT NULL,`zelazo` int(10) NOT NULL,`piasek` int(10) NOT NULL,`wegiel` int(10) NOT NULL,"
        				+ "`redstone` int(10) NOT NULL,`lapis` int(10) NOT NULL,`proch` int(10) NOT NULL,`perly` int(10) NOT NULL,`slimeball` int(10) NOT NULL,`jablka` int(10) NOT NULL,`ksiazki` int(10) NOT NULL,"
        				+ "`skrzynki` int(10) NOT NULL,`coinsy` int(10) NOT NULL,`cobble` int(10) NOT NULL, `expireTimeExp` bigint(13),`turboexp` int(10) NOT NULL NOT NULL);");
        	store.update(true, "CREATE TABLE IF NOT EXISTS `{P}guilds` (" + ((store.getStoreMode() == StoreMode.MYSQL) ? "`id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," : "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,") +
        				"`tag` varchar(4) NOT NULL,`name` varchar(32) NOT NULL,`owner` varchar(36) NOT NULL,`leader` varchar(36) NOT NULL,`cuboidWorld` varchar(32) NOT NULL,`cuboidX` int(10) NOT NULL,"
        				+ "`cuboidZ` int(10) NOT NULL,`cuboidSize` int(10) NOT NULL,`liveSize` int(11) NOT NULL,`liveCool` bigint(22) NOT NULL,`homeWorld` varchar(32) NOT NULL,`homeX` int(10) NOT NULL,`homeY` int(10) NOT NULL,"
        				+ "`homeZ` int(10) NOT NULL,`createTime` bigint(13) NOT NULL DEFAULT '0',`expireTime` bigint(13) NOT NULL DEFAULT '0',`playersLimit` int(13) NOT NULL DEFAULT '0',`pvp` int(1) NOT NULL DEFAULT '0', `points` int(16) NOT NULL"
        				+ ",`limitFurnace` int(4) NOT NULL,`limitFence` int(4) NOT NULL,`limitSign` int(4) NOT NULL,`limitButton` int(4) NOT NULL,`limitLever` int(4) NOT NULL NOT NULL);");
        	store.update(true, "CREATE TABLE IF NOT EXISTS `{P}alliances` (" + (store.getStoreMode() == StoreMode.MYSQL ? "`id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," : "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,") + 
        				"`guild_1` varchar(255) NOT NULL,`guild_2` varchar(255) NOT NULL,`pvp` int(1) NOT NULL,`breakBlock` int(1) NOT NULL NOT NULL);");
        	store.update(true, "CREATE TABLE IF NOT EXISTS `{P}members` (" + ((store.getStoreMode() == StoreMode.MYSQL) ? "`id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," : "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,") +
        				" `uuid` varchar(36) NOT NULL,`name` varchar(255) NOT NULL,`tag` varchar(255) NOT NULL NOT NULL);");
        	store.update(true, "CREATE TABLE IF NOT EXISTS `{P}hardcore` (" + ((store.getStoreMode() == StoreMode.MYSQL) ? "`id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," : "`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,") +
        				" `uuid` varchar(255) NOT NULL,`ban_start_time` bigint(20) NOT NULL,`ban_end_time` bigint(20) NOT NULL,`ip` varchar(50) NOT NULL,`desc` varchar(20) NOT NULL,`unban` int(5) NOT NULL NOT NULL);");
        }else if (Config.DATABASE_SERVER_TYPE.equalsIgnoreCase("skyblock")){
        	
        }
        }
        return conn;
    }
    
    public static void registerListener(Plugin plugin, Listener... listeners) {
        if (API.pluginManager == null) {
            API.pluginManager = Bukkit.getPluginManager();
        }
        for (Listener listener : listeners) {
            API.pluginManager.registerEvents(listener, plugin);
        }
    }
    
    public static void registerCommand(Command command) {
        CommandManager.register(command);
    }
    public static void registerConfig(pl.blackwaterapi.configs.ConfigCreator config){
    	ConfigManager.register(config);
    }
    
    public static API getPlugin() {
        return API.plugin;
    }  
    public static Store getStore() {
        return API.store;
    }
    
    public static PluginManager getPluginManager() {
        return API.pluginManager;
    }
    
    
    public static SocketTask getSocketTask() {
        return API.socketTask;
    }
}

