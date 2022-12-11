package com.example.LaboDocker.services;

import com.example.LaboDocker.models.DataModel;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.apache.tomcat.util.json.ParseException;
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
public class DataServices {

    private List<DataModel> allStats = new ArrayList<>();

    public List<DataModel> getAllStats() {
        return allStats;
    }

    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void weatherData() throws IOException, InterruptedException, ParseException {
        List<DataModel> newDatas = new ArrayList<>();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://weatherapi-com.p.rapidapi.com/current.json?q=Lausanne"))
                .header("X-RapidAPI-Key", "0b6df8825fmshf3d59c26eacae31p1c8113jsn3da9280aca87")
                .header("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        JsonNode jsonNode = new ObjectMapper().readTree(response.body());
        String name = String.valueOf(jsonNode.get("location").get("name"));
        String current = String.valueOf(jsonNode.get("current").get("temp_c"));
        DataModel dataModel = new DataModel();
        dataModel.setName(name);
        dataModel.setData(current);
        newDatas.add(dataModel);
        this.allStats = newDatas;

    }


    public void randomJoke() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://dad-jokes.p.rapidapi.com/random/joke"))
                .header("X-RapidAPI-Key", "0b6df8825fmshf3d59c26eacae31p1c8113jsn3da9280aca87")
                .header("X-RapidAPI-Host", "dad-jokes.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }


    public void footData() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://football-prediction-api.p.rapidapi.com/api/v2/predictions?market=classic&iso_date=2018-12-01&federation=UEFA"))
                .header("X-RapidAPI-Key", "0b6df8825fmshf3d59c26eacae31p1c8113jsn3da9280aca87")
                .header("X-RapidAPI-Host", "football-prediction-api.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }


    public void newsData() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.thenewsapi.com/v1/news/top?api_token=wF6q09WqJvJaWVJx5iXdAoQ6BnabKZICvCdEXDhw"))
                .header("limit", "20")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        JsonNode jsonNode = new ObjectMapper().readTree(response.body());
        String name = String.valueOf(jsonNode.get("location").get("name"));
        String current = String.valueOf(jsonNode.get("current").get("temp_c"));
        System.out.println(response.body());
    }
}
