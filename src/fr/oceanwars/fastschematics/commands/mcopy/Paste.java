package fr.oceanwars.fastschematics.commands.mcopy;

import fr.oceanwars.fastschematics.commands.AbstractCommand;
import fr.oceanwars.fastschematics.managers.SchematicsManager;
import fr.oceanwars.fastschematics.utils.MSchematicData;
import org.bukkit.entity.Player;

public class Paste extends AbstractCommand {

    public Paste(int id) {
        super(id);
    }

    @Override
    public void execute(Player player, String[] args) {
        if (!SchematicsManager.getInstance().playerHasData(player)) {
            player.sendMessage("§cYou need to load a schematic first");
            player.sendMessage("§cTry to run §6/mcopy load [file]");
            return;
        }
        MSchematicData data = SchematicsManager.getInstance().getPlayerData(player);
        SchematicsManager.getInstance().removePlayerData(player);
        data.paste(player.getLocation());
    }

    @Override
    public String getHelp() {
        return "Allow to paste your previously loaded schematic with /mcopy load [file]";
    }
}
