package fr.oceanwars.fastschematics.managers;

import org.bukkit.entity.Player;

public final class SchematicsManager {
    private static SchematicsManager instance = new SchematicsManager();

    public static SchematicsManager getInstance() {
        return instance;
    }

    private SchematicsManager() { }


    /**
     * This method allow us to create the schematic object and save it at file given
     * @param player The player that have saved the schematics
     * @param fileName The name of the file that we have to set it
     */
    public void createSchematic(Player player, String fileName) {
        
    }
}
