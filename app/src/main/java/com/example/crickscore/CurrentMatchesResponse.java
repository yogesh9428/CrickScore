package com.example.crickscore;

import java.util.List;

public class CurrentMatchesResponse {
    private List<Match> data;

    public List<Match> getData() {
        return data;
    }

    public void setData(List<Match> data) {
        this.data = data;
    }
}
