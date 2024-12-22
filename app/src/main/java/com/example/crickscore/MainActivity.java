package com.example.crickscore;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.recentcrickscore.RecentMatchActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MatchAdapter matchAdapter;
    private List<Match> matchList;
    private CricApiService apiService;
    private ProgressBar progressBar;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGoToRecent = findViewById(R.id.recentmatches);
        Button btnGoToUpcoming = findViewById(R.id.upcomingMatches);

        btnGoToRecent.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, com.example.recentcrickscore.RecentMatchActivity.class);
            startActivity(intent);
        });

        btnGoToUpcoming.setOnClickListener(v -> {
            Log.d("ButtonCLick" , "Button is pressed");
            Intent intent = new Intent(MainActivity.this, com.example.upcomingcrickscore.UpcomingMatchActivity.class);
            startActivity(intent);
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        progressBar = findViewById(R.id.progressBar);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);

        matchList = new ArrayList<>();

        apiService = ApiClient.getRetrofitInstance().create(CricApiService.class);

        swipeRefreshLayout.setOnRefreshListener(this::fetchMatches);

        matchAdapter = new MatchAdapter(matchList);
        recyclerView.setAdapter(matchAdapter);

        fetchMatches();
    }

    private void fetchMatches() {
        progressBar.setVisibility(View.VISIBLE);
        swipeRefreshLayout.setRefreshing(true);

        apiService.getLiveMatches().enqueue(new Callback<CurrentMatchesResponse>() {
            @Override
            public void onResponse(Call<CurrentMatchesResponse> call, Response<CurrentMatchesResponse> response) {
                progressBar.setVisibility(View.GONE);
                swipeRefreshLayout.setRefreshing(false);

                if (response.isSuccessful() && response.body() != null) {
                    List<Match> matches = response.body().getData();

                    List<Match> filteredMatches = MatchDataHelper.processMatches(matches);

                    matchAdapter.updateMatchList(filteredMatches);
                } else {
                    Log.e("MainActivity", "Error: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<CurrentMatchesResponse> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                swipeRefreshLayout.setRefreshing(false);
                Log.e("MainActivity", "Network failure: " + t.getMessage());
            }
        });
    }
}
