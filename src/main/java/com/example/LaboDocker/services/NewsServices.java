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
public class NewsServices {
    private List<DataModel> allStats = new ArrayList<>();

    public List<DataModel> getAllStats() {
        return allStats;
    }
    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void newsData() throws IOException, InterruptedException {
        List<DataModel> newDatas = new ArrayList<>();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.thenewsapi.com/v1/news/top?api_token=wF6q09WqJvJaWVJx5iXdAoQ6BnabKZICvCdEXDhw"))
                .header("limit", "5")
                .header("language", "en")
                .header("source", "e2news.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        JsonNode jsonNode = new ObjectMapper().readTree(response.body());
        System.out.println(jsonNode.get("data"));
        System.out.println(jsonNode.get("data").get(1).get("title"));
        System.out.println(jsonNode.get("data").get(1).get("description"));
        System.out.println(jsonNode.get("data").get(1).get("snippet"));
        System.out.println(jsonNode.get("data").get(0).get("title"));
        System.out.println(jsonNode.get("data").get(0).get("description"));
        System.out.println(jsonNode.get("data").get(0).get("snippet"));
        System.out.println(jsonNode.get("data").get(2).get("title"));
        System.out.println(jsonNode.get("data").get(2).get("description"));
        System.out.println(jsonNode.get("data").get(2).get("snippet"));
        System.out.println(jsonNode.get("data").get(3).get("title"));
        System.out.println(jsonNode.get("data").get(3).get("description"));
        System.out.println(jsonNode.get("data").get(3).get("snippet"));
        System.out.println(jsonNode.get("data").get(4).get("title"));
        System.out.println(jsonNode.get("data").get(4).get("description"));
        System.out.println(jsonNode.get("data").get(4).get("snippet"));
//        String url = String.valueOf(jsonNode.get("data").get(0).get("image_url"));
//        String name = String.valueOf(jsonNode.get("location").get("name"));
//        String current = String.valueOf(jsonNode.get("current").get("temp_c"));
//        DataModel dataModel = new DataModel();
//        dataModel.setName(name);
//        dataModel.setData(current);
//        newDatas.add(dataModel);
//        this.allStats = newDatas;
    }
}
