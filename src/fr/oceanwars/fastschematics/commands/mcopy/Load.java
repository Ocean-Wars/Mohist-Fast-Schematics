package fr.oceanwars.fastschematics.commands.mcopy;

import fr.oceanwars.fastschematics.commands.AbstractCommand;
import fr.oceanwars.fastschematics.managers.SchematicsManager;
import fr.oceanwars.fastschematics.utils.FileUtils;
import fr.oceanwars.fastschematics.utils.serializable.MSchematicData;
import org.bukkit.entity.Player;

import java.io.File;

public class Load extends AbstractCommand {

    public Load(int id) {
        super(id);
    }

    @Override
    public void execute(Player player, String[] args) {
        String fileName = args[1].replace(".mschematic", "");
        File file = SchematicsManager.getInstance().getFileFromFileName(fileName);
        if (!file.exists()) {
            player.sendMessage("§cThe schematic: §6" + args[1] + " §cdoes not exists! Please verify your schematics " +
                    "folder.");
            return;
        }
        MSchematicData data = (MSchematicData) FileUtils.readObjectFromFile(file);
        SchematicsManager.getInstance().setPlayerSchematic(data, player);
        player.sendMessage("§aSuccessfully loaded schematic, you can now run §6/mcopy paste §ato paste your " +
                "schematic!");
        player.sendMessage("§aYou have 1 minute to run this command.");
    }

    @Override
    public String getHelp() {
        return "Allow you to load a schematic from an mschematic file";
    }

    @Override
    public String getUsage() {
        return super.getUsage() + " [file]";
    }

    @Override
    public boolean needMoreArg() {
        return true;
    }
}
