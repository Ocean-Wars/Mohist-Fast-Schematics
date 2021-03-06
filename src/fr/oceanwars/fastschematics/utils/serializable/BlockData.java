package fr.oceanwars.fastschematics.utils.serializable;

import org.bukkit.Material;
import org.bukkit.block.Block;

import java.io.Serializable;

public class BlockData implements Serializable {
    private String material;
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
        this.material = material.toString();
        this.data = data;
    }

    public Material getMaterial() {
        return Material.getMaterial(material);
    }

    public void setMaterial(Material material) {
        this.material = material.toString();
    }

    public byte getData() {
        return data;
    }

    public void setData(byte data) {
        this.data = data;
    }
}
