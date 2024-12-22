package com.example.crickscore;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;


public interface CricApiService {

    @Headers({
            "x-rapidapi-key: cbee4b88a6msh443ecb3c9cf4713p17ca51jsna5fd9568c902",
            "x-rapidapi-host: cricket-live-line1.p.rapidapi.com"
    })
    @GET("liveMatches")
    Call<CurrentMatchesResponse> getLiveMatches();

    @Headers({
            "x-rapidapi-key: cbee4b88a6msh443ecb3c9cf4713p17ca51jsna5fd9568c902",
            "x-rapidapi-host: cricket-live-line1.p.rapidapi.com"
    })

    @GET("recentMatches")
    Call<CurrentMatchesResponse> getRecentMatches();

    @Headers({
            "x-rapidapi-key: cbee4b88a6msh443ecb3c9cf4713p17ca51jsna5fd9568c902",
            "x-rapidapi-host: cricket-live-line1.p.rapidapi.com"
    })

    @GET("upcomingMatches")
    Call<CurrentMatchesResponse> getUpcomingMatches();

}


