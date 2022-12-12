package com.example.LaboDocker.models;

import org.springframework.stereotype.Service;

@Service
public class DataModel {

    private String name;
    private String data;

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
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
