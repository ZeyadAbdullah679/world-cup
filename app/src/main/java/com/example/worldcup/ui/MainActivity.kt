package com.example.worldcup.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.worldcup.data.DataManager
import com.example.worldcup.data.domain.Match
import com.example.worldcup.databinding.ActivityMainBinding
import com.example.worldcup.util.CsvParser
import java.io.BufferedReader
import java.io.InputStreamReader


class MainActivity:AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        openFile()
        val adapter = MatchAdapter(DataManager.matches.reversed())
        binding.recyclerMatch.adapter = adapter
    }

    private fun openFile() {
        val inputStream = assets.open("worldcup.csv")
        val buffer = BufferedReader(InputStreamReader(inputStream))
        val parser = CsvParser()
        buffer.forEachLine {
            DataManager.addMatch(parser.parse(it))
        }
    }
}