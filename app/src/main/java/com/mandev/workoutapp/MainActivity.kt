package com.mandev.workoutapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.mandev.workoutapp.databinding.ActivityMainBinding
import com.segment.analytics.Analytics
import com.segment.analytics.Properties

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    /**
     * This method is auto created by Android when the Activity Class is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        //This call the parent constructor
        super.onCreate(savedInstanceState)
        // This is used to align the xml view to this class
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val analytics = Analytics.Builder(
            applicationContext,
            "GWCIxxb4coPAurTTdGiTLTwAKih76R0p"
        )
            .trackApplicationLifecycleEvents()
            .recordScreenViews()
            .build()
        Analytics.setSingletonInstance(analytics)
        Analytics.with(applicationContext)
            .track("Main Activity Started", Properties().putValue("App Name", "Workout App").putValue("Splashscreen", true))

        // Click event for start Button which we have created in XML.
        binding.llStart.setOnClickListener {
            Analytics.with(applicationContext)
                .track("Main Activity Start Clicked", Properties().putValue("App Name", "Workout App").putValue("Splashscreen", true))
            val intent = Intent(this, ExerciseActivity::class.java)
            startActivity(intent)
        }

        binding.llBMI.setOnClickListener {
            Analytics.with(applicationContext)
                .track("Main Activity BMI Clicked", Properties().putValue("App Name", "Workout App").putValue("Splashscreen", true))
            // Launching the BMI Activity
            val intent = Intent(this, BMIActivity::class.java)
            startActivity(intent)
        }

        binding.llHistory.setOnClickListener {
            Analytics.with(applicationContext)
                .track("Main Activity History Clicked", Properties().putValue("App Name", "Workout App").putValue("Splashscreen", true))
            // Launching the History Activity
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }
    }
}