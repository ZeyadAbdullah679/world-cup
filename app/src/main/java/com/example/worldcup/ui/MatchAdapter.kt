package com.example.worldcup.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.worldcup.R
import com.example.worldcup.data.domain.Match
import com.example.worldcup.databinding.ItemMatchBinding

class MatchAdapter(val list: List<Match>) : RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        return MatchViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false)
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val currentMatch = list[position]
        holder.binding.apply {
            textTeam2.text = currentMatch.homeTeamName
            textTeam1.text = currentMatch.awayTeamName
            textTeam1Score.text = currentMatch.homeTeamGoals.toString()
            textTeam2Score.text = currentMatch.awayTeamGoals.toString()
            textYear.text = currentMatch.year.toString()
            if(currentMatch.homeTeamGoals>currentMatch.awayTeamGoals){
                textTeam1Score.setTextColor(ContextCompat.getColor(holder.binding.root.context, R.color.green))
                textTeam2Score.setTextColor(ContextCompat.getColor(holder.binding.root.context, R.color.purple_700))
            }
            else if(currentMatch.homeTeamGoals<currentMatch.awayTeamGoals){
                textTeam1Score.setTextColor(ContextCompat.getColor(holder.binding.root.context, R.color.purple_700 ))
                textTeam2Score.setTextColor(ContextCompat.getColor(holder.binding.root.context, R.color.green))
            }
            else{
                textTeam1Score.setTextColor(ContextCompat.getColor(holder.binding.root.context, R.color.purple_700))
                textTeam2Score.setTextColor(ContextCompat.getColor(holder.binding.root.context, R.color.purple_700))
            }
        }
    }

    class MatchViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
        val binding = ItemMatchBinding.bind(viewItem)
    }
}