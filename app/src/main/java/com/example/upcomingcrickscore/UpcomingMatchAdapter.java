package com.example.upcomingcrickscore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.crickscore.Match;
import com.example.crickscore.R;
import com.example.recentcrickscore.RecentMatchAdapter;

import java.util.List;

public class UpcomingMatchAdapter extends RecyclerView.Adapter<UpcomingMatchAdapter.MatchViewHolder> {

    private List<Match> matchList;
    public UpcomingMatchAdapter(List<Match> matchList) {
        this.matchList = matchList;
    }

    @Override
    public MatchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.update_match_card, parent, false);
        return new MatchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MatchViewHolder holder, int position) {

        Match match = matchList.get(position);
        holder.team1FullName.setText(match.getTeam1FullName());
        holder.team2FullName.setText(match.getTeam2FullName());
        holder.matchTime.setText( match.getStartTime() + " : " +match.getStartDate());
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
        TextView team1FullName, team2FullName, matchTime, series, matchDetails;

        public MatchViewHolder(View itemView) {
            super(itemView);
            // Find and initialize the views
            team1FullName = itemView.findViewById(R.id.team1_fullName);
            team2FullName = itemView.findViewById(R.id.team2_fullName);
            series = itemView.findViewById(R.id.seriesName);
            matchDetails = itemView.findViewById(R.id.matchDetails);
            matchTime = itemView.findViewById(R.id.matchStartDate);

        }
    }
}
