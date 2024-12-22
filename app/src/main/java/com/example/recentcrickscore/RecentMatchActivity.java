package com.example.recentcrickscore;

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

public class RecentMatchActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecentMatchAdapter recentMatchAdapter;  // Using MatchAdapter for simplicity
    private List<Match> matchList;
    private CricApiService apiService;
    private ProgressBar progressBar;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recent_match_activity);

        recyclerView = findViewById(R.id.recyclerViewRecent);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        progressBar = findViewById(R.id.progressbarrecent);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshrecentLayout);

        matchList = new ArrayList<>();
        apiService = ApiClient.getRetrofitInstance().create(CricApiService.class);

        swipeRefreshLayout.setOnRefreshListener(this::fetchRecentMatches);

        recentMatchAdapter = new RecentMatchAdapter(matchList);
        recyclerView.setAdapter(recentMatchAdapter);

        fetchRecentMatches();
    }

    private void fetchRecentMatches() {

        progressBar.setVisibility(View.VISIBLE);
        swipeRefreshLayout.setRefreshing(true);

        MatchDataHelper.fetchrecentMatches(apiService, "recent", recentMatchAdapter, new Runnable() {
            @Override
            public void run() {

                progressBar.setVisibility(View.GONE);
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}
