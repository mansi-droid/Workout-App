package com.mandev.workoutapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.mandev.workoutapp.databinding.ActivityHistoryBinding
import com.segment.analytics.Analytics
import com.segment.analytics.Properties

class HistoryActivity : AppCompatActivity() {
    lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_history)

        setSupportActionBar(binding.toolbarHistoryActivity)

        supportActionBar?.setDisplayHomeAsUpEnabled(true) //set back button
        supportActionBar?.title = "HISTORY" // Setting an title in the action bar.

        binding.toolbarHistoryActivity.setNavigationOnClickListener {
            onBackPressed()
        }

        getAllCompletedDates()
    }

    /**
     * Function is used to get the list exercise completed dates.
     */
    private fun getAllCompletedDates() {

        // Instance of the Sqlite Open Helper class.
        val dbHandler = SqliteOpenHelper(this, null)

        val allCompletedDatesList =
            dbHandler.getAllCompletedDatesList() // List of history table data

        Analytics.with(applicationContext)
            .track("History Activty Started", Properties().putValue("App Name", "Workout App").putValue("HistorySize", allCompletedDatesList.size))
        // TODO(Step 3 : Now here the dates which were printed in log.
        //  We will pass that list to the adapter class which we have created and bind it to the recycler view.)
        // START
        if (allCompletedDatesList.size > 0) {
            // Here if the List size is greater then 0 we will display the item in the recycler view or else we will show the text view that no data is available.
            binding.tvHistory.visibility = View.VISIBLE
            binding.rvHistory.visibility = View.VISIBLE
            binding.tvNoDataAvailable.visibility = View.GONE

            // Creates a vertical Layout Manager
            binding.rvHistory.layoutManager = LinearLayoutManager(this)

            // History adapter is initialized and the list is passed in the param.
            val historyAdapter = HistoryAdapter(this, allCompletedDatesList)

            // Access the RecyclerView Adapter and load the data into it
            binding.rvHistory.adapter = historyAdapter
        } else {
            binding.tvHistory.visibility = View.GONE
            binding.rvHistory.visibility = View.GONE
            binding.tvNoDataAvailable.visibility = View.VISIBLE
        }
        // END
    }
}