package fr.oceanwars.fastschematics.utils;


import org.bukkit.Location;

public class PlayerSelection {
    private Location pos1;
    private Location pos2;

    public PlayerSelection() {
    }

    public Location getPos1() {
        return pos1;
    }

    public void setPos1(Location pos1) {
        this.pos1 = pos1;
    }

    public Location getPos2() {
        return pos2;
    }

    public void setPos2(Location pos2) {
        this.pos2 = pos2;
    }
}
