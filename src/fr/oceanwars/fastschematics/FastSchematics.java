package fr.oceanwars.fastschematics;

import fr.oceanwars.fastschematics.commands.MCopy;
import org.bukkit.plugin.java.JavaPlugin;

public class FastSchematics extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("mcopy").setExecutor(new MCopy());
    }

    @Override
    public void onDisable() {

    }
}
