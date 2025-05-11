package foodaddition.api.handlers.commands;

import foodaddition.FoodAddition;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.util.ChatComponentText;

import java.util.List;

public class RefreshFoodEffects extends CommandBase {

    @Override
    public String getCommandName() {
        return FoodAddition.modID;
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/foodaddition refresh";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length == 1 && "refresh".equalsIgnoreCase(args[0]))
            try {
                FoodAddition.effectHandler.reload();
                sender.addChatMessage(new ChatComponentText("§a[Food Addition] Potion effects config reloaded"));
            } catch (Exception e) {
                sender.addChatMessage(new ChatComponentText("§c[Food Addition] Failed to reload config: " + e.getMessage()));
            }
        else
            throw new WrongUsageException(getCommandUsage(sender));
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List addTabCompletionOptions(ICommandSender sender, String[] args) {
        if (args.length == 1)
            return getListOfStringsMatchingLastWord(args, "refresh");
        return null;
    }
}
