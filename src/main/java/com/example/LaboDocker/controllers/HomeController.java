package com.example.LaboDocker.controllers;

import com.example.LaboDocker.models.DataModel;
import com.example.LaboDocker.services.WeatherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
//    WeatherServices weatherServices;

    @GetMapping("/")
    public String home() {
//        List<DataModel> allStats = weatherServices.getAllStats();

//        String location = allStats.get(0).getName();
//        String temp = allStats.get(0).getData();
//        model.addAttribute("location", location);
//        model.addAttribute("temp", temp);

        return "home";
    }
}
