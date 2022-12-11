package com.example.LaboDocker.controllers;

import com.example.LaboDocker.models.DataModel;
import com.example.LaboDocker.services.DataServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    DataServices dataServices;

    @GetMapping("/")
    public String home(Model model) {
        List<DataModel> allStats = dataServices.getAllStats();
//        int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
//        int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFormPrevDay()).sum();
        String location = allStats.get(0).getName();
        String temp = allStats.get(0).getData();
        model.addAttribute("location", location);
        model.addAttribute("temp", temp);
//        model.addAttribute("totalReportedCases", totalReportedCases);
//        model.addAttribute("totalNewCases", totalNewCases);
        return "home";
    }
}
