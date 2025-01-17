package at.helpch.chatchat.command;

import at.helpch.chatchat.ChatChatPlugin;
import at.helpch.chatchat.api.ChatUser;
import dev.triumphteam.cmd.bukkit.annotation.Permission;
import dev.triumphteam.cmd.core.BaseCommand;
import dev.triumphteam.cmd.core.annotation.Command;
import dev.triumphteam.cmd.core.annotation.Default;
import dev.triumphteam.cmd.core.annotation.Optional;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.jetbrains.annotations.NotNull;

@Command(value = "socialspy", alias = {"sspy", "pmspy", "spy"})
public final class SocialSpyCommand extends BaseCommand {
    private static final String MESSAGE_PERMISSION = "chatchat.socialspy";
    private final ChatChatPlugin plugin;

    public SocialSpyCommand(@NotNull final ChatChatPlugin plugin) {
        this.plugin = plugin;
    }

    @Default
    @Permission(MESSAGE_PERMISSION)
    public void socialSpy(final ChatUser user, @Optional final String toggle) {
        final boolean newState = toggle == null ?
                !plugin.usersHolder().isSocialSpy(user.uuid()) :
                toggle.equals("true") || toggle.equals("yes") || toggle.equals("on");

        plugin.usersHolder().setSocialSpy(user.uuid(), newState);
        user.sendMessage(Component.text("Social spy " + (newState ? "enabled" : "disabled"), NamedTextColor.GREEN));
    }
}
