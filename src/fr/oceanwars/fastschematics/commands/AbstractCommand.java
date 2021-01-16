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

    /**
     * This allow us to set the usage of the command (in case there need one more arg)
     * The [command] is getting substitute by the command name.
     * @return The usage of the command
     */
    public String getUsage() {
        return "/[command]";
    }

    /**
     * If the command need one more argument, we set this to true.
     * @return {code true} if the command require another argument, otherwise {@code false}
     */
    public boolean needMoreArg() {
        return false;
    }
}
