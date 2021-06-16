package com.example.apirest_recyclerview_cardviews.models;

public class revista {
    private int issue_id;
    private String title;
    private int volume;
    private int number;
    private int year;
    private String cover;

    public revista(int issue_id, String title, int volume, int number, int year, String cover) {
        this.issue_id = issue_id;
        this.title = title;
        this.volume = volume;
        this.number = number;
        this.year = year;
        this.cover = cover;

    }

    public int getIssue_id() {
        return issue_id;
    }

    public void setIssue_id(int issue_id) {
        this.issue_id = issue_id;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
