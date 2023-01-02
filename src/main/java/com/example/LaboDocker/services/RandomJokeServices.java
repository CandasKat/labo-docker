package com.example.LaboDocker.services;

import com.example.LaboDocker.models.DataModel;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class RandomJokeServices {
    private List<DataModel> jokes = new ArrayList<>();

    public List<DataModel> getJokes() {
        return jokes;
    }
    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void randomJoke() throws IOException, InterruptedException {
        List<DataModel> newDatas = new ArrayList<>();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://dad-jokes.p.rapidapi.com/random/joke"))
                .header("X-RapidAPI-Key", "0b6df8825fmshf3d59c26eacae31p1c8113jsn3da9280aca87")
                .header("X-RapidAPI-Host", "dad-jokes.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        JsonNode jsonNode = new ObjectMapper().readTree(response.body());
        DataModel joke = new DataModel();
        joke.setDescription(String.valueOf(jsonNode.get("body").get(0).get("setup")));
        joke.setData(String.valueOf(jsonNode.get("body").get(0).get("punchline")));
        newDatas.add(joke);
        this.jokes = newDatas;
    }
}
