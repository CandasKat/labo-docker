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
    private List<DataModel> allNews = new ArrayList<>();

    public List<DataModel> getAllNews() {
        return allNews;
    }
    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void newsData() throws IOException, InterruptedException {
        List<DataModel> newDatas = new ArrayList<>();
        HttpRequest request = HttpRequest.newBuilder()

                .uri(URI.create("https://api.thenewsapi.com/v1/news/top?api_token=wF6q09WqJvJaWVJx5iXdAoQ6BnabKZICvCdEXDhw&locale=ch&limit=5&language=fr"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        JsonNode jsonNode = new ObjectMapper().readTree(response.body());

        for (int i = 0; i < 5; i++) {
            DataModel news = new DataModel();

            news.setName(String.valueOf(jsonNode.get("data").get(i).get("title")));
            news.setData(String.valueOf(jsonNode.get("data").get(i).get("description")));
            news.setDescription(String.valueOf(jsonNode.get("data").get(i).get("snippet")));
            news.setImg(String.valueOf(jsonNode.get("data").get(i).get("image_url")));
            news.setUrl(String.valueOf(jsonNode.get("data").get(i).get("url")));
            newDatas.add(news);
        }
        this.allNews = newDatas;
    }
}
