package com.mandev.workoutapp

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mandev.workoutapp.databinding.ItemHistoryRowBinding

// TODO(Step 2 : Created a adapter class to bind the to RecyclerView to show the list of completed dates in History Screen.)
// START
class HistoryAdapter(val context: Context, val items: ArrayList<String>) :
    RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    /**
     * Inflates the item views which is designed in xml layout file
     *
     * create a new
     * {@link ViewHolder} and initializes some private fields to be used by RecyclerView.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: ItemHistoryRowBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_history_row, parent, false)
        return ViewHolder(v)
    }

    /**
     * Binds each item in the ArrayList to a view
     *
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     *
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val date: String = items.get(position)

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

    /**
     * Gets the number of items in the list
     */
    override fun getItemCount(): Int {
        return items.size
    }

    /**
     * A ViewHolder describes an item view and metadata about its place within the RecyclerView.
     */
    inner class ViewHolder(bindingAdapter: ItemHistoryRowBinding) : RecyclerView.ViewHolder(bindingAdapter.root) {
        var bindingAdapter: ItemHistoryRowBinding = bindingAdapter
    }
}
// END