package fr.oceanwars.fastschematics.commands;

import org.bukkit.entity.Player;

/**
 * This class allow us to create simple subcommands for the plugin
 */
public abstract class AbstractCommand {

    /**
     * The id field define the argument that we are currently in.
     * for example:
     * /mcopy pos1
     * id = 0, beacause args[0] == pos1
     */
    protected final int id;

    public AbstractCommand(int id) {
        this.id = id;
    }

    /**
     * This command is run during the execution.
     * @param player The player that has run the command
     * @param args The arguments of the command. Where args[id] is the subcommand.
     */
    public abstract void execute(Player player, String[] args);

    /**
     * This method allow us to get the description of the command
     * @return The help message that is displayed this way:
     * §6/mcopy [command]§e: getHelp()
     */
    public abstract String getHelp();
}
