package eventlisteners;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class GetCurrentLatency implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        if (messageCreateEvent.getMessageContent().equalsIgnoreCase("!ms")) {
            long starttime = System.nanoTime();

            long endTime = System.nanoTime();
            String result = "It took " + (endTime - starttime) + " milliseconds to get to your command. The avg time is around 100 ms";
            EmbedBuilder embed = new EmbedBuilder()
                    .setTitle("Ping")
                    .setDescription("Check how the bot is handling your requests")
                    .addField("Result", result)
                    .setFooter("click this link to see what this means https://www.maketecheasier.com/what-is-ping/");
            messageCreateEvent.getChannel().sendMessage(embed);
        }
    }
}
