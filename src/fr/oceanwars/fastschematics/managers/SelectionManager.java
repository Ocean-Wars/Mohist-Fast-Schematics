package fr.oceanwars.fastschematics.managers;

import fr.oceanwars.fastschematics.utils.PlayerSelection;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class SelectionManager {
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
}
