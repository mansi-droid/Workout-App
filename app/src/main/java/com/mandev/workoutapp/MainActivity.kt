package com.mandev.workoutapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mandev.workoutapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.llStart.setOnClickListener {
            startActivity(Intent(this, ExerciseActivity::class.java))
        }

        binding.llBMI.setOnClickListener {
            startActivity(Intent(this, BMIActivity::class.java))
        }

        binding.llHistory.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }
    }
}