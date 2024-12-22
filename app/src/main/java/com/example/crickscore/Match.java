package com.example.crickscore;

import com.google.gson.annotations.SerializedName;


public class Match {

    @SerializedName("series")
    private String series;

    @SerializedName("matchs")
    private String match;

    @SerializedName("venue")
    private String venue;

    @SerializedName("team_a")
    private String team1FullName;

    @SerializedName("team_b")
    private String team2FullName;

    @SerializedName("team_a_short")
    private String team1Name;

    @SerializedName("team_b_short")
    private String team2Name;

    @SerializedName("team_a_scores")
    private String team1score;
    @SerializedName("team_a_over")
    private String team1Over;


    @SerializedName("team_b_scores")
    private String team2score;

    @SerializedName("team_b_over")
    private String team2Over;

    @SerializedName("result")
    private String result;

    @SerializedName("date_wise")
    private String startDate;

    @SerializedName("match_time")
    private String startTime;

    public String getTeam1FullName() {
        return team1FullName;
    }

    public void setTeam1FullName(String team1FullName) {
        this.team1FullName = team1FullName;
    }

    public String getTeam2FullName() {
        return team2FullName;
    }

    public void setTeam2FullName(String team2FullName) {
        this.team2FullName = team2FullName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public String getTeam2Name() {
        return team2Name;
    }

    public void setTeam2Name(String team2Name) {
        this.team2Name = team2Name;
    }

    public String getTeam1Name() {
        return team1Name;
    }

    public void setTeam1Name(String team1Name) {
        this.team1Name = team1Name;
    }

    public String getTeam2score() {
        return team2score;
    }

    public void setTeam2score(String team2score) {
        this.team2score = team2score;
    }

    public String getTeam1score() {
        return team1score;
    }

    public void setTeam1score(String team1score) {
        this.team1score = team1score;
    }

    public String getTeam1Over() {
        return team1Over;
    }

    public void setTeam1Over(String team1Over) {
        this.team1Over = team1Over;
    }

    public String getTeam2Over() {
        return team2Over;
    }

    public void setTeam2Over(String team2Over) {
        this.team2Over = team2Over;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
