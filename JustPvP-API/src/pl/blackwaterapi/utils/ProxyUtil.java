package pl.blackwaterapi.utils;

import java.net.URL;
import java.util.Scanner;

public class ProxyUtil
{
  public static Boolean ProxyCheck(String IP, String Url, String trigger)
    throws Exception
  {
    String res = "";
    Scanner ProxyChecker = new Scanner(new URL(Url + IP).openStream());
    while (ProxyChecker.hasNextLine()) {
      res = res + ProxyChecker.nextLine();
    }
    ProxyChecker.close();
    if (res.contains(trigger)) {
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }
}
