package fr.oceanwars.fastschematics.commands.mcopy;

import fr.oceanwars.fastschematics.commands.AbstractCommand;
import fr.oceanwars.fastschematics.managers.SchematicsManager;
import fr.oceanwars.fastschematics.managers.SelectionManager;
import org.bukkit.entity.Player;

public class Save extends AbstractCommand {

    public Save(int id) {
        super(id);
    }

    @Override
    public void execute(Player player, String[] args) {
        if (!SelectionManager.getInstance().isSelectionValid(player)) {
            player.sendMessage("§cInvalid selection!");
            player.sendMessage("§cPlease set your selection correctly with:");
            player.sendMessage("§6/mcopy pos1 §cand §6/mcopy pos2");
        } else {
            String path = SchematicsManager.getInstance().createSchematic(player, args[1]);
            player.sendMessage("§aSuccessfully created mohist schematic at path: §6" + path);
            player.sendMessage("§aPlease wait until you see a console message saying that the load is finished");
        }
    }

    @Override
    public String getHelp() {
        return "Allow you to save the schematic to the file filename";
    }

    @Override
    public String getUsage() {
        return super.getUsage() + " [filename]";
    }

    @Override
    public boolean needMoreArg() {
        return true;
    }
}
