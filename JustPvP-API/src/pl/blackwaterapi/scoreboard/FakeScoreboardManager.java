package pl.blackwaterapi.scoreboard;

import java.util.WeakHashMap;

import org.bukkit.entity.Player;

public class FakeScoreboardManager
{
    private static WeakHashMap<Player, FakeScoreboard> fakeScoreboards;
    
    static {
        fakeScoreboards = new WeakHashMap<Player, FakeScoreboard>();
    }
    
    public static FakeScoreboard getFakeScoreboard(Player p) {
        FakeScoreboard fakeScoreboard = FakeScoreboardManager.fakeScoreboards.get(p);
        if (fakeScoreboard == null) {
            fakeScoreboard = createFakeScoreboard(p);
        }
        return fakeScoreboard;
    }
    
    public static FakeScoreboard createFakeScoreboard(Player p) {
        FakeScoreboard fakeScoreboard = new FakeScoreboard(p);
        FakeScoreboardManager.fakeScoreboards.put(p, fakeScoreboard);
        return fakeScoreboard;
    }
    
    public static WeakHashMap<Player, FakeScoreboard> getFakeScoreboards() {
        return FakeScoreboardManager.fakeScoreboards;
    }
}
