package com.example.crickscore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.MatchViewHolder> {

    private List<Match> matchList;

    public MatchAdapter(List<Match> matchList) {
        this.matchList = matchList;
    }

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.match_card, parent, false);  // Inflate the layout for each item
        return new MatchViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder holder, int position) {
        Match match = matchList.get(position);


        holder.siriesName.setText(match.getSeries() != null ? match.getSeries() : "Unknown Series");
        holder.matchName.setText(match.getMatch() != null ? match.getMatch() + " , " + match.getVenue(): "Unknown Match");
        holder.team1Name.setText(match.getTeam1Name() != null ? match.getTeam1Name() : "Team A");
        holder.team2Name.setText(match.getTeam2Name() != null ? match.getTeam2Name() : "Team B");
        holder.team1Score.setText(match.getTeam1score() != null ? match.getTeam1score() : "N/A");
        holder.team2Score.setText(match.getTeam2score() != null ? match.getTeam2score() : "N/A");
    }

    @Override
    public int getItemCount() {
        return matchList.size();
    }

    public void updateMatchList(List<Match> matches) {
        this.matchList = matches;
        notifyDataSetChanged();  // For large lists, consider using DiffUtil
    }

    public static class MatchViewHolder extends RecyclerView.ViewHolder {
        public TextView siriesName, matchName, team1Name, team2Name, team1Score, team2Score;

        public MatchViewHolder(View view) {
            super(view);

            // Bind views
            siriesName = view.findViewById(R.id.seriesName);
            matchName = view.findViewById(R.id.matchDetails);
            team1Name = view.findViewById(R.id.team1Name);
            team2Name = view.findViewById(R.id.team2Name);
            team1Score = view.findViewById(R.id.team1Score);
            team2Score = view.findViewById(R.id.team2Score);
        }
    }
}
