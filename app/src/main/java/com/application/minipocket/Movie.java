package com.application.minipocket;

public class Movie {
    int id;
    String title,poster, release_date;

    public Movie(int id, String title, String poster, String release_date) {
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.release_date = release_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String image) {
        this.poster = image;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
}
