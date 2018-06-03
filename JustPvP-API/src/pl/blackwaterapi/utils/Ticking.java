package pl.blackwaterapi.utils;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.LinkedList;

import org.bukkit.Bukkit;

import pl.blackwaterapi.API;


public class Ticking
  implements Runnable
{
  @SuppressWarnings({ "unchecked", "rawtypes" })
public Ticking()
  {
    this.lastPoll = System.nanoTime();
    (this.history = new LinkedList()).add(Double.valueOf(20.0D));
  }
  
  public void start()
  {
    Bukkit.getScheduler().runTaskTimer(API.getPlugin(), this, 1000L, 50L);
  }
  
  public void run()
  {
    long startTime = System.nanoTime();
    long timeSpent = (startTime - this.lastPoll) / 1000L;
    if (timeSpent == 0L) {
      timeSpent = 1L;
    }
    if (this.history.size() > 10) {
      this.history.remove();
    }
    double tps = 5.0E7D / timeSpent;
    if (tps <= 21.0D) {
      this.history.add(Double.valueOf(tps));
    }
    this.lastPoll = startTime;
    double avg = 0.0D;
    for (Double f : this.history) {
      if (f != null) {
        avg += f.doubleValue();
      }
    }
    df.setRoundingMode(RoundingMode.HALF_UP);
    result = df.format(avg / this.history.size());
  }
  
  public static String getTPS()
  {
    return result;
  }
  
  private static DecimalFormat df = new DecimalFormat("#,###.##");
  private transient long lastPoll;
  private LinkedList<Double> history;
  private static String result = "20.0";
}
