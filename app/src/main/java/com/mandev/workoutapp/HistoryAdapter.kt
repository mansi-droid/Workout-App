package com.mandev.workoutapp

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mandev.workoutapp.databinding.ItemHistoryRowBinding

class HistoryAdapter(val context : Context, private val items : ArrayList<String>) :
    RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : ViewHolder {
        val v : ItemHistoryRowBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_history_row, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder : ViewHolder, position : Int) {
        val date : String = items[position]

        holder.bindingAdapter.tvPosition.text = (position + 1).toString()
        holder.bindingAdapter.tvItem.text = date

        // Updating the background color according to the odd/even positions in list.
        if (position % 2 == 0) {
            holder.bindingAdapter.llHistoryItemMain.setBackgroundColor(
                Color.parseColor("#EBEBEB")
            )
        } else {
            holder.bindingAdapter.llHistoryItemMain.setBackgroundColor(
                Color.parseColor("#FFFFFF")
            )
        }
    }

    override fun getItemCount() : Int {
        return items.size
    }

    inner class ViewHolder(var bindingAdapter : ItemHistoryRowBinding) :
        RecyclerView.ViewHolder(bindingAdapter.root)
}
