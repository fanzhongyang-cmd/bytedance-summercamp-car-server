package com.example.cartype.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;


public class Score {
    private int user;
    private int series;
    private int score;
    private long time=System.currentTimeMillis();

    public void setUser(int user) {
        this.user = user;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getUser() {
        return user;
    }

    public int getSeries() {
        return series;
    }

    public int getScore() {
        return score;
    }

    public long getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Score{" +
                "user=" + user +
                ", series=" + series +
                ", score=" + score +
                ", time=" + time +
                '}';
    }
}
