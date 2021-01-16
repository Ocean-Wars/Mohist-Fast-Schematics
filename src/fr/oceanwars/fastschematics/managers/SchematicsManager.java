package fr.oceanwars.fastschematics.managers;

import fr.oceanwars.fastschematics.MohistSchematics;
import fr.oceanwars.fastschematics.utils.FileUtils;
import fr.oceanwars.fastschematics.utils.MSchematicData;
import fr.oceanwars.fastschematics.utils.PlayerSelection;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.io.File;

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
     * @return A {@code String} containing the path to the file created.
     */
    public String createSchematic(Player player, String fileName) {
        PlayerSelection selection = SelectionManager.getInstance().getPlayerSelection(player);
        PlayerSelection newSelection = sanitizeSelection(selection);
        MSchematicData data = createData(player, newSelection);
        return writeToFile(data, fileName);
    }

    /**
     * This method allow us to write to the file
     * @param data The data that we have to write
     * @param fileName The name of the file that we have to write to
     * @return The path to the file
     */
    private String writeToFile(MSchematicData data, String fileName) {
        File target = new File(MohistSchematics.getInstance().getDataFolder(),
                "schematics" + File.pathSeparator + fileName);
        if (!target.getParentFile().exists())
            target.getParentFile().mkdirs();

        FileUtils.writeObjectToFile(target, data);
        return target.getAbsolutePath();
    }

    /**
     * This method allow us to create a new selection from selection that satisfy the following predicate:
     * x1 < x2 && y1 < y2 && z1 < z2
     * x1, y1, z1 are the coordinates of pos1 and x2, y2, z2 are the coordinates of pos2.
     * @param selection The selection of the user
     * @return The selection sanitized.
     */
    private PlayerSelection sanitizeSelection(PlayerSelection selection) {
        final Location pos1 = selection.getPos1();
        final Location pos2 = selection.getPos2();

        final Location newPos1 = new Location(pos1.getWorld(),
                Math.min(pos1.getBlockX(), pos2.getBlockX()),
                Math.min(pos1.getBlockY(), pos2.getBlockY()),
                Math.min(pos1.getBlockZ(), pos2.getBlockZ()));

        Location newPos2 = new Location(pos1.getWorld(),
                Math.max(pos1.getBlockX(), pos2.getBlockX()),
                Math.max(pos1.getBlockY(), pos2.getBlockY()),
                Math.max(pos1.getBlockZ(), pos2.getBlockZ()));

        return new PlayerSelection(newPos1, newPos2);
    }

    /**
     * This method allow us to create a MSchematicData according to player position and the selection of the player
     * @param player The player that has done the command
     * @param newSelection The selection of the player that has been previously sanitized with
     * {@link SchematicsManager#sanitizeSelection(PlayerSelection)}
     * @return The MSChematicData according to player selection
     */
    private MSchematicData createData(Player player, PlayerSelection newSelection) {
        return new MSchematicData(player.getLocation(), newSelection.getPos1(), newSelection.getPos2());
    }
}
