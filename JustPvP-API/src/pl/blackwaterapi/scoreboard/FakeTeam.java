package pl.blackwaterapi.scoreboard;

import java.util.HashSet;
import java.util.Set;

import com.comphenix.packetwrapper.WrapperPlayServerScoreboardTeam;

import pl.blackwaterapi.utils.Util;

public class FakeTeam
{
    public FakeScoreboard fakeScoreboard;
    private String name;
    private Set<String> members;
    boolean teamExists;
    private String displayName;
    private String prefix;
    private String suffix;
    
    public FakeTeam(FakeScoreboard fakeScoreboard, String name) {
        super();
        this.members = new HashSet<String>();
        this.fakeScoreboard = fakeScoreboard;
        this.name = name;
        this.displayName = this.name;
        this.prefix = "";
        this.suffix = "";
        this.teamExists = false;
        this.createTeam();
    }
    
    private void createTeam() {
        this.teamExists = true;
        WrapperPlayServerScoreboardTeam w = new WrapperPlayServerScoreboardTeam();
        w.setTeamName(this.name);
        w.setTeamDisplayName(this.displayName);
        w.setTeamPrefix(this.prefix);
        w.setTeamSuffix(this.suffix);
        w.setPacketMode((byte)0);
        w.sendPacket(this.fakeScoreboard.getPlayer());
    }
    
    public void setPrefix(String prefix) {
        prefix = prefix.substring(0, Math.min(prefix.length(), 16));
        prefix = Util.fixColor(prefix);
        this.prefix = prefix;
        if (this.teamExists) {
            WrapperPlayServerScoreboardTeam w = new WrapperPlayServerScoreboardTeam();
            w.setTeamName(this.name);
            w.setTeamDisplayName(this.displayName);
            w.setTeamPrefix(this.prefix);
            w.setTeamSuffix(this.suffix);
            w.setPacketMode((byte)2);
            w.sendPacket(this.fakeScoreboard.getPlayer());
        }
    }
    
    public void setSuffix(String suffix) {
        suffix = suffix.substring(0, Math.min(suffix.length(), 16));
        suffix = Util.fixColor(suffix);
        this.suffix = suffix;
        if (this.teamExists) {
            WrapperPlayServerScoreboardTeam w = new WrapperPlayServerScoreboardTeam();
            w.setTeamName(this.name);
            w.setTeamDisplayName(this.displayName);
            w.setTeamPrefix(this.prefix);
            w.setTeamSuffix(this.suffix);
            w.setPacketMode((byte)2);
            w.sendPacket(this.fakeScoreboard.getPlayer());
        }
    }
    
    public void addMember(String member) {
        this.members.add(member);
        if (this.teamExists) {
            WrapperPlayServerScoreboardTeam w = new WrapperPlayServerScoreboardTeam();
            w.setTeamName(this.name);
            w.setPacketMode((byte)3);
            w.setPlayers(this.members);
            w.sendPacket(this.fakeScoreboard.getPlayer());
        }
    }
    
    public void removeMember(String member) {
        this.members.remove(member);
        if (this.teamExists) {
            WrapperPlayServerScoreboardTeam w = new WrapperPlayServerScoreboardTeam();
            w.setTeamName(this.name);
            w.setPacketMode((byte)4);
            w.setPlayers(this.members);
            w.sendPacket(this.fakeScoreboard.getPlayer());
        }
    }
    
    public boolean isMember(String member) {
        return this.members.contains(member);
    }
    
    public void removeTeam() {
        if (!this.teamExists) {
            return;
        }
        this.teamExists = false;
        WrapperPlayServerScoreboardTeam w = new WrapperPlayServerScoreboardTeam();
        w.setTeamName(this.name);
        w.setPacketMode((byte)1);
        w.sendPacket(this.fakeScoreboard.getPlayer());
    }
    
    public FakeScoreboard getFakeScoreboard() {
        return this.fakeScoreboard;
    }
    
    public String getName() {
        return this.name;
    }
    
    public Set<String> getMembers() {
        return this.members;
    }
    
    public boolean isTeamExists() {
        return this.teamExists;
    }
    
    public String getDisplayName() {
        return this.displayName;
    }
    
    public String getPrefix() {
        return this.prefix;
    }
    
    public String getSuffix() {
        return this.suffix;
    }
    
    public void setTeamExists(boolean teamExists) {
        this.teamExists = teamExists;
    }
    
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
