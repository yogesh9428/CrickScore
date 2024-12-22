package com.example.crickscore;

import android.util.Log;

import com.example.recentcrickscore.RecentMatchAdapter;
import com.example.upcomingcrickscore.UpcomingMatchAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatchDataHelper {

    public static List<Match> processMatches(List<Match> matches) {
        List<Match> filteredMatches = new ArrayList<>();
        int limit = Math.min(20, matches.size());  // Limit to 15 matches or less if there are fewer

        for (int i = 0; i < limit; i++) {
            Match match = matches.get(i);
            try {
                // Format scores
                match.setTeam1score(match.getTeam1score() + " (" + match.getTeam1Over() + " ov)");
                match.setTeam2score(match.getTeam2score() + " (" + match.getTeam2Over() + " ov)");

                // Add to the filtered list
                filteredMatches.add(match);
            } catch (Exception e) {
                Log.e("MatchDataHelper", "Error processing match data: " + e.getMessage());
            }
        }
        return filteredMatches;
    }


    public static void fetchMatches(CricApiService apiService, String endpoint, MatchAdapter adapter, Runnable onComplete) {
        Call<CurrentMatchesResponse> call;

        call = apiService.getLiveMatches();


        call.enqueue(new Callback<CurrentMatchesResponse>() {
            @Override
            public void onResponse(Call<CurrentMatchesResponse> call, Response<CurrentMatchesResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Match> matches = response.body().getData();
                    List<Match> filteredMatches = processMatches(matches);
                    adapter.updateMatchList(filteredMatches);
                } else {
                    Log.e("MatchDataHelper", "Error: " + response.message());
                }

                if (onComplete != null) {
                    onComplete.run();
                }
            }

            @Override
            public void onFailure(Call<CurrentMatchesResponse> call, Throwable t) {
                Log.e("MatchDataHelper", "Network failure: " + t.getMessage());
                if (onComplete != null) {
                    onComplete.run();
                }
            }
        });
    }

    public static void fetchrecentMatches(CricApiService apiService, String endpoint, RecentMatchAdapter adapter, Runnable onComplete) {
        Call<CurrentMatchesResponse> call;

        call = apiService.getRecentMatches();


        call.enqueue(new Callback<CurrentMatchesResponse>() {
            @Override
            public void onResponse(Call<CurrentMatchesResponse> call, Response<CurrentMatchesResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Match> matches = response.body().getData();
                    List<Match> filteredMatches = processMatches(matches);
                    adapter.updateMatchList(filteredMatches);
                } else {
                    Log.e("MatchDataHelper", "Error: " + response.message());
                }

                if (onComplete != null) {
                    onComplete.run();
                }
            }

            @Override
            public void onFailure(Call<CurrentMatchesResponse> call, Throwable t) {
                Log.e("MatchDataHelper", "Network failure: " + t.getMessage());
                if (onComplete != null) {
                    onComplete.run();
                }
            }
        });
    }

    public static void fetchupcominges(CricApiService apiService, String endpoint, UpcomingMatchAdapter adapter, Runnable onComplete) {
        Call<CurrentMatchesResponse> call;

        call = apiService.getUpcomingMatches();


        call.enqueue(new Callback<CurrentMatchesResponse>() {
            @Override
            public void onResponse(Call<CurrentMatchesResponse> call, Response<CurrentMatchesResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Match> matches = response.body().getData();
                    List<Match> filteredMatches = processMatches(matches);
                    adapter.updateMatchList(filteredMatches);
                } else {
                    Log.e("MatchDataHelper", "Error: " + response.message());
                }

                if (onComplete != null) {
                    onComplete.run();
                }
            }

            @Override
            public void onFailure(Call<CurrentMatchesResponse> call, Throwable t) {
                Log.e("MatchDataHelper", "Network failure: " + t.getMessage());
                if (onComplete != null) {
                    onComplete.run();
                }
            }
        });
    }


}


