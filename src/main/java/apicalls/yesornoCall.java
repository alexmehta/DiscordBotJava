package apicalls;

import org.javacord.api.entity.message.MessageBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class yesornoCall {
    public MessageBuilder answer(String s) throws IOException, ParseException {
        MessageBuilder builder = new MessageBuilder();
        String requester = "https://yesno.wtf/api";
        URL URL = new URL(requester);
        HttpURLConnection con = (HttpURLConnection) URL.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        FileWriter fileWriter = new FileWriter("src/main/java/apicalls/resources/yes.json");
        fileWriter.write("");
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
            fileWriter.append(inputLine + "\n");
        }
        fileWriter.close();
        in.close();
        con.disconnect();
        // parsing file "json"
        Object obj = new JSONParser().parse(new FileReader("src/main/java/apicalls/resources/yes.json"));
        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;
        String value = (String) jo.get("answer");
        String imageLink = (String) jo.get("image");
        builder.append("Question: " + s.substring(s.indexOf(' ')));
        builder.append("\nAnswer: " + value).addAttachment(new URL(imageLink));
        //builder has performance issues, switch to an embed?
        return builder;
    }
}
