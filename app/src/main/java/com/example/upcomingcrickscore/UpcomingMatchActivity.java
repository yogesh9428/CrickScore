package com.example.upcomingcrickscore;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.crickscore.ApiClient;
import com.example.crickscore.CricApiService;
import com.example.crickscore.Match;
import com.example.crickscore.MatchDataHelper;
import com.example.crickscore.R;

import java.util.ArrayList;
import java.util.List;

public class UpcomingMatchActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private UpcomingMatchAdapter upcomingMatchAdapter;
    private List<Match> matchList;

    private CricApiService apiService;

    private ProgressBar progressBar;

    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upcoming_match_activity);

        recyclerView = findViewById(R.id.recyclerView_upcoming);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        progressBar = findViewById(R.id.progressbar_upcoming);

        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout_upcoming);

        matchList = new ArrayList<>();
        apiService = ApiClient.getRetrofitInstance().create(CricApiService.class);

        swipeRefreshLayout.setOnRefreshListener(this::fetchUpcomingMatches);

        upcomingMatchAdapter = new UpcomingMatchAdapter(matchList);
        recyclerView.setAdapter(upcomingMatchAdapter);

        fetchUpcomingMatches();
    }

    private void fetchUpcomingMatches(){
        progressBar.setVisibility(View.VISIBLE);
        swipeRefreshLayout.setRefreshing(true);

        MatchDataHelper.fetchupcominges(apiService, "upcoming", upcomingMatchAdapter, new Runnable() {
            @Override
            public void run() {

                progressBar.setVisibility(View.GONE);
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}

