package fr.oceanwars.fastschematics.commands.mcopy;

import fr.oceanwars.fastschematics.commands.AbstractCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class MCopy implements CommandExecutor {

    private final HashMap<String, AbstractCommand> subCommands = new HashMap<String, AbstractCommand>() {{
        put("pos1", new Pos1(0));
        put("pos2", new Pos2(0));
        put("save", new Pos2(0));
    }};

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("§cOnly players can perform this command!");
            return true;
        }
        Player p = (Player) commandSender;
        if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
            sendHelp(p);
        } else {
            if (!subCommands.containsKey(args[0].toLowerCase())) {
                p.sendMessage("§6Unknown command §c" + args[0] + " §6please run §c/mcopy help");
            } else {
                subCommands.get(args[0]).execute(p, args);
            }
        }
        return true;
    }

    private void sendHelp(Player p) {
        p.sendMessage("§6/mcopy help§e: Display this help message");
        subCommands.forEach((arg, cmd) -> {
            p.sendMessage("§6" + cmd.getUsage().replace("[command]", arg) + "§e: " + cmd.getHelp());
        });
    }
}
