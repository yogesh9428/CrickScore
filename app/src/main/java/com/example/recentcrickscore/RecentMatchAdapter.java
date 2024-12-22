package com.example.recentcrickscore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.crickscore.Match;
import com.example.crickscore.R;

import java.util.List;

public class RecentMatchAdapter extends RecyclerView.Adapter<RecentMatchAdapter.MatchViewHolder> {

    private List<Match> matchList;
    public RecentMatchAdapter(List<Match> matchList) {
        this.matchList = matchList;
    }

    @Override
    public MatchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recent_match_card, parent, false);
        return new MatchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MatchViewHolder holder, int position) {

        Match match = matchList.get(position);
        holder.team1Name.setText(match.getTeam1Name());
        holder.team1Score.setText(match.getTeam1score());
        holder.team2Name.setText(match.getTeam2Name());
        holder.team2Score.setText(match.getTeam2score());
        holder.matchResult.setText(match.getResult());
        holder.series.setText(match.getSeries() != null ? match.getSeries() : "Unknown Series");
        holder.matchDetails.setText(match.getMatch() != null ? match.getMatch() + " , " + match.getVenue(): "Unknown Match");
    }

    @Override
    public int getItemCount() {
        return matchList.size();
    }

    // Method to update the match list
    public void updateMatchList(List<Match> updatedMatches) {
        this.matchList.clear();
        this.matchList.addAll(updatedMatches);
        notifyDataSetChanged();
    }

    // ViewHolder class for each item in the RecyclerView
    public class MatchViewHolder extends RecyclerView.ViewHolder {
        TextView team1Name, team1Score, team2Name, team2Score, matchResult, series, matchDetails;

        public MatchViewHolder(View itemView) {
            super(itemView);
            // Find and initialize the views
            team1Name = itemView.findViewById(R.id.team1Name);
            team1Score = itemView.findViewById(R.id.team1Score);
            team2Name = itemView.findViewById(R.id.team2Name);
            team2Score = itemView.findViewById(R.id.team2Score);
            series = itemView.findViewById(R.id.seriesName);
            matchDetails = itemView.findViewById(R.id.matchDetails);
            matchResult = itemView.findViewById(R.id.matchResult);
        }
    }
}
