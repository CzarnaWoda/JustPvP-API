package pl.blackwaterapi.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.CommandSender;

import pl.blackwaterapi.utils.Util;

public abstract class Command extends org.bukkit.command.Command
{
    private String name;
    private String usage;
    private String desc;
    private String permission;
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public Command(String name, String desc, String usage, String permission, String... aliases) {
        super(name, desc, usage, (List)Arrays.asList(aliases));
        this.name = name;
        this.usage = usage;
        this.desc = desc;
        this.permission = permission;
    }
    
    public boolean execute(CommandSender sender, String label, String[] args) {
        if ((this.permission != null || this.permission != "") && !sender.hasPermission(this.permission)) {
            return Util.sendMsg(sender, "&9• &6Nie Posiadasz Uprawnien &8(&c" + permission + "&8)");
        }
        return this.onExecute(sender, args);
    }
    
    public abstract boolean onExecute(CommandSender p0, String[] p1);
    
    public String getName() {
        return this.name;
    }
    
    public String getUsage() {
        return this.usage;
    }
    
    public String getDesc() {
        return this.desc;
    }
    
    public String getPermission() {
        return this.permission;
    }
}
