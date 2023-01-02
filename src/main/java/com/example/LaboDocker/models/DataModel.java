package com.example.LaboDocker.models;

import org.springframework.stereotype.Service;

@Service
public class DataModel {

    private String home;
    private String away;
    private String competitionName;
    private String result;
    private boolean isExpired;
    private String name;
    private String data;
    private String description;
    private String img;
    private String url;

    public String getUrl() {
        return url.replaceAll("\"", "");
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getAway() {
        return away;
    }

    public void setAway(String away) {
        this.away = away;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg() {
        return img.replaceAll("\"", "");
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description.translateEscapes();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name.translateEscapes();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data.translateEscapes();
    }

    public void setData(String data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "LocationStats{" +
                "location='" + name + '\'' +
                ", temp='" + data + '}';
    }
}
