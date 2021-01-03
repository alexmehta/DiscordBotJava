import eventlisteners.GetCurrentLatency;
import eventlisteners.apis.trumpListen;
import eventlisteners.apis.yesnoListener;
import eventlisteners.counter.counter;
import eventlisteners.counter.resetCounter;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.util.logging.FallbackLoggerConfiguration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("src/main/java/eventlisteners/counter/resources/num")));
        counter.counter = new BigInteger(bufferedReader.readLine());
        DiscordApi api = new DiscordApiBuilder().setToken("NzU5ODgwODkyNzE3NDY1NjEy.X3D8Og.pt1Z6Zmsc1w9aV22XnCx0-cG7Qs")
                .login()
                .join();
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!ping")) event.getChannel().sendMessage("Pong");
        });
        api.addListener(new GetCurrentLatency());
        api.addListener(new counter());
        api.addListener(new resetCounter());
        api.addListener(new trumpListen());
        api.addListener(new yesnoListener());
        // Enable debug logging
        FallbackLoggerConfiguration.setDebug(true);
        // Enable trace logging
        FallbackLoggerConfiguration.setTrace(true);

    }

}
