package com.example.LaboDocker.controllers;

import com.example.LaboDocker.models.DataModel;
import com.example.LaboDocker.services.NewsServices;
import com.example.LaboDocker.services.RandomActivityServices;
import com.example.LaboDocker.services.RandomJokeServices;
import com.example.LaboDocker.services.WeatherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    NewsServices newsServices;
    @Autowired
    WeatherServices weatherServices;
    @Autowired
    RandomJokeServices jokeServices;
    @Autowired
    RandomActivityServices activityServices;

    @GetMapping("/")
    public String home(Model model) {
        // weather
        List<DataModel> allStats = weatherServices.getAllStats();
        String location = allStats.get(0).getName();
        String temp = allStats.get(0).getData();
        model.addAttribute("location", location);
        model.addAttribute("temp", temp);

        //news
        List<DataModel> allNews = newsServices.getAllNews();
        model.addAttribute("getNews", allNews);

        // jokes
        List<DataModel> allJokes = jokeServices.getJokes();
        String jokeDescription = allJokes.get(0).getDescription();
        String jokeData = allJokes.get(0).getData();
        model.addAttribute("getJokeDescription", jokeDescription);
        model.addAttribute("getJokeData", jokeData);

        // activities
        List<DataModel> activities = activityServices.getAllActivity();
        String activityDescription = activities.get(0).getDescription();
        String activityData = activities.get(0).getData();
        model.addAttribute("getActivityDescription", activityDescription);
        model.addAttribute("getActivityData", activityData);

        return "home";
    }

    public void gettingNews(Model model) {

    }
}
