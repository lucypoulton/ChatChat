package at.helpch.chatchat.config.holders;

import at.helpch.chatchat.config.DefaultConfigObjects;
import at.helpch.chatchat.format.PMFormat;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;

@ConfigSerializable
public final class SettingsHolder {

    private PMFormat senderFormat = DefaultConfigObjects.createPrivateMessageSenderFormat();

    private PMFormat recipientFormat = DefaultConfigObjects.createPrivateMessageRecipientFormat();
    private PMFormat socialSpyFormat = DefaultConfigObjects.createPrivateMessageSocialSpyFormat();

    public @NotNull PMFormat getSenderFormat() {
        return senderFormat;
    }

    public @NotNull PMFormat getRecipientFormat() {
        return recipientFormat;
    }

    public @NotNull PMFormat getSocialSpyFormat() {
        return socialSpyFormat;
    }
}
