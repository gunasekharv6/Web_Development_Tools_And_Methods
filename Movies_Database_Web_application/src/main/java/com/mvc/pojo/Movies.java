/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvc.pojo;

/**
 *
 * @author gunav
 */
public class Movies {
    String title;
    String actor;
    String actress;
    String genre;
    int year;

    public Movies(String Title, String Actor, String Actress, String genre, int year) {
        this.title = Title;
        this.actor = Actor;
        this.actress = Actress;
        this.genre = genre;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String Title) {
        this.title = Title;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String Actor) {
        this.actor = Actor;
    }

    public String getActress() {
        return actress;
    }

    public void setActress(String Actress) {
        this.actress = Actress;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
