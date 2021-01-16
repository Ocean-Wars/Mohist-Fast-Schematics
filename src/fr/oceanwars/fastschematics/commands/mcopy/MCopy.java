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
                p.sendMessage("§cUnknown command §6" + args[0] + " §cplease run §6/mcopy help");
            } else {
                if (subCommands.get(args[0]).needMoreArg() && !(args.length >= 2)) {
                    p.sendMessage("§cThe subcommand §6" + args[0] + " §crequire 1 more argument.");
                    p.sendMessage("§cPlease run §6/mcopy help §c for more information.");
                } else {
                    subCommands.get(args[0]).execute(p, args);
                }
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
