package eventlisteners.counter;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.math.BigInteger;

public class resetCounter implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        if (messageCreateEvent.getMessageContent().equalsIgnoreCase("!reset") && messageCreateEvent.getMessageAuthor().isBotOwner()) {
            counter.counter = BigInteger.ZERO;
            messageCreateEvent.getChannel().sendMessage("Reset to 0");
        }
        if (messageCreateEvent.getMessageContent().equalsIgnoreCase("!reset") && !messageCreateEvent.getMessageAuthor().isBotOwner()) {
            messageCreateEvent.getChannel().sendMessage("Only the bot owner can do that command");
        }
    }
}
