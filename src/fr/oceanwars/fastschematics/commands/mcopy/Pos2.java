package fr.oceanwars.fastschematics.commands.mcopy;

import fr.oceanwars.fastschematics.commands.AbstractCommand;
import fr.oceanwars.fastschematics.managers.SelectionManager;
import org.bukkit.entity.Player;

public class Pos2 extends AbstractCommand {

    public Pos2(int id) {
        super(id);
    }

    @Override
    public void execute(Player player, String[] args) {
        SelectionManager.getInstance().setPos2(player);
        player.sendMessage("§aSuccessfully set the pos2");
    }

    @Override
    public String getHelp() {
        return "Set the second position of the copy to your the location at your feets";
    }
}
