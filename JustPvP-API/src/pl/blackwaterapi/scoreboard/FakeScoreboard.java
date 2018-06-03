package pl.blackwaterapi.scoreboard;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.entity.Player;

public class FakeScoreboard
{
    private Player player;
    private Set<FakeTeam> fakeTeams;
    
    public FakeScoreboard(Player player) {
        super();
        this.fakeTeams = new HashSet<FakeTeam>();
        this.player = player;
    }
    
    public FakeTeam createFakeTeam(String name) {
        if (this.getFakeTeam(name) != null) {
            throw new IllegalArgumentException("Team with name '" + name + "' for player '" + this.player.getName() + "' already exists!");
        }
        FakeTeam fakeTeam = new FakeTeam(this, name);
        this.fakeTeams.add(fakeTeam);
        return fakeTeam;
    }
    
    public FakeTeam getFakeTeam(String name) {
        for (FakeTeam fakeTeam : this.getFakeTeams()) {
            if (fakeTeam.getName().equalsIgnoreCase(name)) {
                return fakeTeam;
            }
        }
        return null;
    }
    
    public void removeFakeTeam(FakeTeam fakeTeam) {
        if (fakeTeam == null) {
            return;
        }
        fakeTeam.removeTeam();
        this.fakeTeams.remove(fakeTeam);
    }
    
    public void removeFakeTeam(String fakeTeam) {
        this.removeFakeTeam(this.getFakeTeam(fakeTeam));
    }
    
    public Player getPlayer() {
        return this.player;
    }
    
    public Set<FakeTeam> getFakeTeams() {
        return this.fakeTeams;
    }
}
