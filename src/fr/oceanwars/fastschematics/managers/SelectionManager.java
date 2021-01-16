package fr.oceanwars.fastschematics.managers;

import fr.oceanwars.fastschematics.utils.PlayerSelection;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;

public final class SelectionManager {
    private static final SelectionManager instance = new SelectionManager();

    private final HashMap<Player, PlayerSelection> playerSelections = new HashMap<>();

    public static SelectionManager getInstance() {
        return instance;
    }

    private SelectionManager() { }


    public void setPos1(Player player) {
        if (!playerSelections.containsKey(player)) {
            playerSelections.put(player, new PlayerSelection());
        }
        playerSelections.get(player).setPos1(player.getLocation());
    }

    public void setPos2(Player player) {
        if (!playerSelections.containsKey(player)) {
            playerSelections.put(player, new PlayerSelection());
        }
        playerSelections.get(player).setPos2(player.getLocation());
    }

    public boolean isSelectionValid(Player player) {
        if (!playerSelections.containsKey(player))
            return false;

        Location pos1 = playerSelections.get(player).getPos1();
        Location pos2 = playerSelections.get(player).getPos2();

        return pos1 != null && pos2 != null
                && pos1.getWorld().equals(pos2.getWorld());
    }

    /**
     * This method allow us to get the selection of the player.
     * You must call {@link SelectionManager#isSelectionValid(Player)} before calling this method.
     * It can generate and exception if the hashmap does not contain the player
     * @param player The player to get the selection
     * @return The selection of the player (pos1 and pos2).
     */
    public PlayerSelection getPlayerSelection(Player player) {
        return playerSelections.get(player);
    }
}
