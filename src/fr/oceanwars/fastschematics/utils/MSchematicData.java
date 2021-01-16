package fr.oceanwars.fastschematics.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import java.io.Serializable;

/**
 * This file contain the data of the schematic
 */
public class MSchematicData implements Serializable {

    /**
     * The location of the player (where to paste it from)
     */
    private BlockLocation playerLocation;

    /**
     * The pos1 that we have to get when pasting according to playerLocation
     */
    private BlockLocation pos1;

    /**
     * The block data, access it this way:
     * blockData[x][y][z]
     */
    private BlockData[][][] blockData;

    /**
     * We must have a public empty constructor in order to make Serializable work.
     * You should not use this contructor.
     */
    public MSchematicData() {

    }

    /**
     * This constructor allow us to create the schematic
     * @param playerLocation The location of the player
     * @param pos1 The first position of the selection of the user
     * @param pos2 The second position of the selection of the user
     */
    public MSchematicData(Location playerLocation, Location pos1, Location pos2) {
        this.playerLocation = new BlockLocation(playerLocation);
        this.pos1 = new BlockLocation(pos1);

        createBlockData(pos1, pos2);
    }

    /**
     * This method allow us to create the blockData by three loops
     * @param pos1 The first position
     * @param pos2 The second position
     */
    private void createBlockData(Location pos1, Location pos2) {
        // Create the data, this has been found after many tests
        blockData = new BlockData
                [Math.abs(pos2.getBlockX() - pos1.getBlockX()) + 1]
                [Math.abs(pos2.getBlockY() - pos1.getBlockY()) + 1]
                [Math.abs(pos2.getBlockZ() - pos1.getBlockZ()) + 1];

        for (int x = 0; x < blockData.length; x++) {
            for (int y = 0; y < blockData[0].length; y++) {
                for (int z = 0; z < blockData[0].length; z++) {
                    blockData[x][y][z] = new BlockData(pos1.getWorld().getBlockAt(
                            pos1.getBlockX() + x,
                            pos1.getBlockY() + y,
                            pos1.getBlockZ() + z));
                }
            }
        }

    }

    private class BlockData implements Serializable {
        private Material material;
        private byte data;

        /**
         * We must have a public empty constructor in order to make Serializable work.
         * You should not use this contructor.
         */
        public BlockData() {

        }

        public BlockData(Block block) {
            this(block.getType(), block.getData());
        }

        public BlockData(Material material, byte data) {
            this.material = material;
            this.data = data;
        }

        public Material getMaterial() {
            return material;
        }

        public void setMaterial(Material material) {
            this.material = material;
        }

        public byte getData() {
            return data;
        }

        public void setData(byte data) {
            this.data = data;
        }
    }

    public BlockLocation getPlayerLocation() {
        return playerLocation;
    }

    public BlockLocation getPos1() {
        return pos1;
    }
}
