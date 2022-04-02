package com.example.dogapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DogBreed implements Serializable {
    @SerializedName("id")
    private int id;

    @SerializedName("bred_for")
    private String bredFor;

    @SerializedName("breed_group")
    private String bredGroup;

    @SerializedName("name")
    private String name;

    @SerializedName("life_span")
    private String lifeSpan;

    @SerializedName("origin")
    private String origin;

    @SerializedName("temperament")
    private String temperament;

    @SerializedName("height")
    private Unit height;

    @SerializedName("weight")
    private Unit weight;

    @SerializedName("url")
    private String url;

    public DogBreed(int id, String bredFor, String bredGroup, String name, String lifeSpan, String origin, String temperament, Unit height, Unit weight, String url) {
        this.id = id;
        this.bredFor = bredFor;
        this.bredGroup = bredGroup;
        this.name = name;
        this.lifeSpan = lifeSpan;
        this.origin = origin;
        this.temperament = temperament;
        this.height = height;
        this.weight = weight;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBredFor() {
        return bredFor;
    }

    public void setBredFor(String bredFor) {
        this.bredFor = bredFor;
    }

    public String getBredGroup() {
        return bredGroup;
    }

    public void setBredGroup(String bredGroup) {
        this.bredGroup = bredGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(String lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public Unit getHeight() {
        return height;
    }

    public void setHeight(Unit height) {
        this.height = height;
    }

    public Unit getWeight() {
        return weight;
    }

    public void setWeight(Unit weight) {
        this.weight = weight;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
