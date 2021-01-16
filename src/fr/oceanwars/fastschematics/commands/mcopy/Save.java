package fr.oceanwars.fastschematics.commands.mcopy;

import fr.oceanwars.fastschematics.commands.AbstractCommand;
import org.bukkit.entity.Player;

public class Save extends AbstractCommand {

    public Save(int id) {
        super(id);
    }

    @Override
    public void execute(Player player, String[] args) {
        
    }

    @Override
    public String getHelp() {
        return "Allow you to save the schematic to the file filename";
    }

    @Override
    public String getUsage() {
        return super.getUsage() + " [filename]";
    }
}
