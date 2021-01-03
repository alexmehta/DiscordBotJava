package eventlisteners.apis;

import apicalls.trumpCall;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class trumpListen implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        if (messageCreateEvent.getMessageContent().equalsIgnoreCase("!trumpquote")) {
            trumpCall f = new trumpCall();
            try {
                EmbedBuilder embed = new EmbedBuilder()
                        .setTitle("Trump Real Quotes (Unfortunately)")
                        .setAuthor("From tronalddump.io", "https://www.tronalddump.io/", "https://www.tronalddump.io/img/tronalddump_850x850.png")
                        .setDescription(f.answer() + "\n-Trump \n (API by https://www.tronalddump.io/)");
                messageCreateEvent.getChannel().sendMessage(embed);
            } catch (IOException | ParseException e) {
                e.printStackTrace();

            }
        }
    }
}
