package fr.oceanwars.fastschematics.commands.mcopy;

import fr.oceanwars.fastschematics.commands.AbstractCommand;
import fr.oceanwars.fastschematics.managers.SelectionManager;
import org.bukkit.entity.Player;

public class Pos1 extends AbstractCommand {

    public Pos1(int id) {
        super(id);
    }

    @Override
    public void execute(Player player, String[] args) {
        SelectionManager.getInstance().setPos1(player);
    }

    @Override
    public String getHelp() {
        return "Set the first position of the copy to your the location at your feets";
    }
}
