package com.example.worldcup.data

import com.example.worldcup.data.domain.Match

object DataManager {
    private val matchesList = mutableListOf<Match>()

    val matches = matchesList

    private var matchIndex = 0
    fun addMatch(match: Match){
        matchesList.add(match)
    }

    fun getCurrentMatch():Match = matchesList[matchIndex]

    fun getNextMatch():Match{
        matchIndex++
        return matchesList[matchIndex]
    }

    fun getPreviousMatch():Match{
        matchIndex--
        return matchesList[matchIndex]
    }
}