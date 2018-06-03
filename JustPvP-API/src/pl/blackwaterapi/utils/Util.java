package pl.blackwaterapi.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Util
{
    private static SimpleDateFormat dateFormat;
    private static SimpleDateFormat timeFormat;
    private static LinkedHashMap<Integer, String> values;
    
    public static String fixColor(String s) {
        if (s == null) {
            return "";
        }
        return ChatColor.translateAlternateColorCodes('&', s);
    }
    
    public static Collection<String> fixColor(Collection<String> collection) {
        Collection<String> local = new ArrayList<String>();
        for (String s : collection) {
            local.add(fixColor(s));
        }
        return local;
    }
    
    public static String[] fixColor(String[] array) {
        for (int i = 0; i < array.length; ++i) {
            array[i] = fixColor(array[i]);
        }
        return array;
    }
    
    public static boolean sendMsg(CommandSender sender, String message, String permission) {
        if (sender instanceof ConsoleCommandSender) {
            sendMsg(sender, message);
        }
        return permission != null && permission != "" && sender.hasPermission(permission) && sendMsg(sender, message);
    }
    
    public static boolean sendMsg(CommandSender sender, String message) {
        if (sender instanceof Player) {
            if (message != null || message != "") {
                sender.sendMessage(fixColor(message));
            }
        }
        else {
            sender.sendMessage(ChatColor.stripColor(fixColor(message)));
        }
        return true;
    }
    
    public static boolean sendMsg(Collection<? extends CommandSender> collection, String message) {
        for (CommandSender cs : collection) {
            sendMsg(cs, message);
        }
        return true;
    }
    
    public static boolean sendMsg(Collection<? extends CommandSender> collection, String message, String permission) {
        for (CommandSender cs : collection) {
            sendMsg(cs, message, permission);
        }
        return true;
    }
    
    public static boolean containsIgnoreCase(String[] array, String element) {
        for (String s : array) {
            if (s.equalsIgnoreCase(element)) {
                return true;
            }
        }
        return false;
    }
    
    public static void copy(InputStream in, File file)
    {
      try
      {
        OutputStream out = new FileOutputStream(file);
        byte[] buf = new byte['?'];
        int len;
        while ((len = in.read(buf)) > 0) {
          out.write(buf, 0, len);
        }
        out.close();
        in.close();
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    
    @SuppressWarnings("deprecation")
	public static Material getMaterial(String idOrName) {
        if (isInteger(idOrName)) {
            return Material.getMaterial(Integer.parseInt(idOrName));
        }
        for (Material m : Material.values()) {
            if (m.name().replace("_", "").equalsIgnoreCase(idOrName)) {
                return m;
            }
        }
        return null;
    }
    
    public static String getContent(String urlName)
    {
      String body = null;
      try
      {
        URL url = new URL(urlName);
        URLConnection con = url.openConnection();
        InputStream in = con.getInputStream();
        String encoding = con.getContentEncoding();
        encoding = encoding == null ? "UTF-8" : encoding;
        body = toString(in, encoding);
        in.close();
      }
      catch (TimeoutException localTimeoutException) {}catch (Exception localException) {}
      return body;
    }
    
    public static String toString(InputStream in, String encoding)
      throws Exception
    {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      byte[] buf = new byte['?'];
      int len = 0;
      while ((len = in.read(buf)) != -1) {
        baos.write(buf, 0, len);
      }
      in.close();
      return new String(baos.toByteArray(), encoding);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static ItemStack getItemStack(Material m, short data, int amount, HashMap<Enchantment, Integer> enchants) {
        ItemStack item = null;
        int a = 64;
        if (amount >= 1) {
            a = amount;
        }
        if (data > 0) {
            item = new ItemStack(m, a);
        }
        else {
            item = new ItemStack(m, a, data);
        }
        if (enchants != null) {
            item.addUnsafeEnchantments((Map)enchants);
        }
        return item;
    }
    
    public static void giveItems(Player p, ItemStack... items) {
        Inventory i = (Inventory)p.getInventory();
        HashMap<Integer, ItemStack> notStored = (HashMap<Integer, ItemStack>)i.addItem(items);
        for (Map.Entry<Integer, ItemStack> e : notStored.entrySet()) {
            p.getWorld().dropItemNaturally(p.getLocation(), (ItemStack)e.getValue());
        }
    }
    
    public static Player getDamager(EntityDamageByEntityEvent e) {
        Entity damager = e.getDamager();
        if (damager instanceof Player) {
            return (Player)damager;
        }
        if (damager instanceof Projectile) {
            Projectile p = (Projectile)damager;
            if (p.getShooter() instanceof Player) {
                return (Player)p.getShooter();
            }
        }
        return null;
    }
    
    public static String secondsToString(int seconds) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, String> e : Util.values.entrySet()) {
            int iDiv = seconds / e.getKey();
            if (iDiv >= 1) {
                int x = (int)Math.floor(iDiv);
                sb.append(x + e.getValue()).append(" ");
                seconds -= x * e.getKey();
            }
        }
        return sb.toString();
    }
    
    public static boolean isAlphaNumeric(String s) {
        return s.matches("^[a-zA-Z0-9_]*$");
    }
    
    public static boolean isFloat(String string) {
        return Pattern.matches("([0-9]*)\\.([0-9]*)", string);
    }
    
    public static boolean isInteger(String string) {
        return Pattern.matches("-?[0-9]+", string.subSequence(0, string.length()));
    }
    
    public static String getDate(long time) {
        return Util.dateFormat.format(new Date(time));
    }
    
    public static String getTime(long time) {
        return Util.timeFormat.format(new Date(time));
    }
    
    public static ItemStack getItemStackFromString(String itemstack) {
        String[] splits = itemstack.split("@");
        String type = splits[0];
        String data = (splits.length == 2) ? splits[1] : null;
        if (data == null) {
            return new ItemStack(Material.getMaterial(type), 1);
        }
        return new ItemStack(Material.getMaterial(type), 1, (short)Integer.parseInt(data));
    }
    
    @SuppressWarnings("deprecation")
	public static String getStringFromItemstack(ItemStack itemstack) {
        if (itemstack.getData().getData() > 0) {
            return itemstack.getType().toString() + "@" + itemstack.getData().getData();
        }
        return itemstack.getType().toString();
    }
    
    public static long parseDateDiff(String time, boolean future) {
        try {
            Pattern timePattern = Pattern.compile("(?:([0-9]+)\\s*y[a-z]*[,\\s]*)?(?:([0-9]+)\\s*mo[a-z]*[,\\s]*)?(?:([0-9]+)\\s*w[a-z]*[,\\s]*)?(?:([0-9]+)\\s*d[a-z]*[,\\s]*)?(?:([0-9]+)\\s*h[a-z]*[,\\s]*)?(?:([0-9]+)\\s*m[a-z]*[,\\s]*)?(?:([0-9]+)\\s*(?:s[a-z]*)?)?", 2);
            Matcher m = timePattern.matcher(time);
            int years = 0;
            int months = 0;
            int weeks = 0;
            int days = 0;
            int hours = 0;
            int minutes = 0;
            int seconds = 0;
            boolean found = false;
            while (m.find()) {
                if (m.group() != null && !m.group().isEmpty()) {
                    for (int i = 0; i < m.groupCount(); ++i) {
                        if (m.group(i) != null && !m.group(i).isEmpty()) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        continue;
                    }
                    if (m.group(1) != null && !m.group(1).isEmpty()) {
                        years = Integer.parseInt(m.group(1));
                    }
                    if (m.group(2) != null && !m.group(2).isEmpty()) {
                        months = Integer.parseInt(m.group(2));
                    }
                    if (m.group(3) != null && !m.group(3).isEmpty()) {
                        weeks = Integer.parseInt(m.group(3));
                    }
                    if (m.group(4) != null && !m.group(4).isEmpty()) {
                        days = Integer.parseInt(m.group(4));
                    }
                    if (m.group(5) != null && !m.group(5).isEmpty()) {
                        hours = Integer.parseInt(m.group(5));
                    }
                    if (m.group(6) != null && !m.group(6).isEmpty()) {
                        minutes = Integer.parseInt(m.group(6));
                    }
                    if (m.group(7) == null) {
                        break;
                    }
                    if (m.group(7).isEmpty()) {
                        break;
                    }
                    seconds = Integer.parseInt(m.group(7));
                    break;
                }
            }
            if (!found) {
                return -1L;
            }
            Calendar c = new GregorianCalendar();
            if (years > 0) {
                c.add(1, years * (future ? 1 : -1));
            }
            if (months > 0) {
                c.add(2, months * (future ? 1 : -1));
            }
            if (weeks > 0) {
                c.add(3, weeks * (future ? 1 : -1));
            }
            if (days > 0) {
                c.add(5, days * (future ? 1 : -1));
            }
            if (hours > 0) {
                c.add(11, hours * (future ? 1 : -1));
            }
            if (minutes > 0) {
                c.add(12, minutes * (future ? 1 : -1));
            }
            if (seconds > 0) {
                c.add(13, seconds * (future ? 1 : -1));
            }
            Calendar max = new GregorianCalendar();
            max.add(1, 10);
            if (c.after(max)) {
                return max.getTimeInMillis();
            }
            return c.getTimeInMillis();
        }
        catch (Exception e) {
            return -1L;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(getDate(1418431585969L));
    }
    
    static {
        dateFormat = new SimpleDateFormat("dd/MM/yyyy, HH:mm:ss");
        timeFormat = new SimpleDateFormat("HH:mm:ss");
        (values = new LinkedHashMap<Integer, String>(6)).put(31104000, "y");
        Util.values.put(2592000, "msc");
        Util.values.put(86400, "d");
        Util.values.put(3600, "h");
        Util.values.put(60, "min");
        Util.values.put(1, "s");
    }
}
