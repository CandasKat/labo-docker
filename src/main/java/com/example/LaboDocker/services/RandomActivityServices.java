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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RandomActivityServices {

    private List<DataModel> allActivity = new ArrayList<>();

    public List<DataModel> getAllActivity() {
        return allActivity;
    }
    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void footData() throws IOException, InterruptedException, ParseException {
        List<DataModel> newActivities = new ArrayList<>();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://www.boredapi.com/api/activity?"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        JsonNode jsonNode = new ObjectMapper().readTree(response.body());
        System.out.println(jsonNode);
        DataModel dataModel = new DataModel();
        dataModel.setData(String.valueOf(jsonNode.get("activity")));
        dataModel.setDescription(String.valueOf(jsonNode.get("type")));
        newActivities.add(dataModel);
        this.allActivity = newActivities;
    }
}
