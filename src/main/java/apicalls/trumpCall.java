package apicalls;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class trumpCall {
    public static void main(String[] args) throws IOException, ParseException {
        trumpCall trumpCall = new trumpCall();
        System.out.println(trumpCall.answer());
    }

    public String answer() throws IOException, ParseException {
        String requester = "https://www.tronalddump.io/random/quote";
        URL URL = new URL(requester);
        HttpURLConnection con = (HttpURLConnection) URL.openConnection();
        con.setRequestMethod("GET");
        int status = con.getResponseCode();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        FileWriter fileWriter = new FileWriter("src/main/java/apicalls/resources/joke.json");
        fileWriter.write("");
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
            fileWriter.append(inputLine + "\n");
        }
        fileWriter.close();
        in.close();
        con.disconnect();
        // parsing file "JSONExample.json"
        Object obj = new JSONParser().parse(new FileReader("src/main/java/apicalls/resources/joke.json"));
        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;
        String joke = (String) jo.get("value");

        return joke;
    }
}
