package com.example.veilingsite.persist;

import io.github.cdimascio.dotenv.Dotenv;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

@Service
public class OpenaiService {

    private final String apiKey;
    private final HttpClient httpClient;
    private final String visionApiUrl;

    public OpenaiService() {
        Dotenv dotenv = Dotenv.load();
        this.apiKey = dotenv.get("OPENAI_API_KEY");
        this.httpClient = HttpClient.newHttpClient();
        this.visionApiUrl = "https://api.openai.com/v1/chat/completions";
    }

    public String maakAltText(String imageUrl) throws Exception {
        JSONArray messages = new JSONArray()
                .put(new JSONObject().put("role", "user").put("content", new JSONArray()
                        .put(new JSONObject().put("type", "text").put("text", "Schrijf alternatieve tekst voor deze afbeelding om te gebruiken op een website. Schrijf slechts één zin, zonder aanhalingstekens."))
                        .put(new JSONObject().put("type", "image_url").put("image_url", new JSONObject().put("url", imageUrl)))));

        JSONObject requestBody = new JSONObject();
        requestBody.put("model", "gpt-4-vision-preview");
        requestBody.put("messages", messages);
        requestBody.put("max_tokens", 50);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(visionApiUrl))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .POST(BodyPublishers.ofString(requestBody.toString()))
                .build();

        HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());

        JSONObject responseBody = new JSONObject(response.body());
        JSONArray choices = responseBody.getJSONArray("choices");
        if (choices.length() == 0) {
            throw new Exception("No choices in API response");
        }

        JSONObject firstChoice = choices.getJSONObject(0);
        JSONObject message = firstChoice.getJSONObject("message");
        if (message.length() == 0) {
            throw new Exception("No message in API response");
        }

        return message.getString("content");
    }
}
