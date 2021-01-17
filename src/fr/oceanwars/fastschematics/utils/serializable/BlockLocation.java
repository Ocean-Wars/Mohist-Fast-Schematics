package fr.oceanwars.fastschematics.utils.serializable;

import org.bukkit.Location;

import java.io.Serializable;

public class BlockLocation implements Serializable {
    private int x;
    private int y;
    private int z;

    // default constructor for Serializable
    public BlockLocation() {

    }

    public BlockLocation(Location location) {
        this.x = location.getBlockX();
        this.y = location.getBlockY();
        this.z = location.getBlockZ();
    }

    public BlockLocation(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}
