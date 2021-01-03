package eventlisteners.apis;

import apicalls.yesornoCall;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Locale;

public class yesnoListener implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        String command = event.getMessageContent().toLowerCase();
        String[] verbals = {"!yes", "!no", "!should", "!shouldI", "!decide"};
        for (String a: verbals) {
            if (command.contains(a.toLowerCase())){
                event.getChannel().sendMessage("This could take a few seconds");
                yesornoCall Call = new yesornoCall();
                try {
                    MessageBuilder s = Call.answer(event.getMessageContent().toLowerCase());
                    System.out.println("sending");
                    s.send(event.getChannel());
                    System.out.println("sent");
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }
                break;
            }
        }

    }
}
