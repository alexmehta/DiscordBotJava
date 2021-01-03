package eventlisteners.counter;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

public class counter implements MessageCreateListener {
    public static BigInteger counter = BigInteger.ZERO;

    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        if (messageCreateEvent.getMessageContent().equalsIgnoreCase("!counter")) {
            counter = BigInteger.ONE.add(counter);
            messageCreateEvent.getChannel().sendMessage("Current count with your addition " + counter);
            try {
                FileWriter fileWriter = new FileWriter("src/main/java/eventlisteners/counter/resources/num");
                BufferedWriter output = new BufferedWriter(fileWriter);
                output.write(counter.toString());
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
