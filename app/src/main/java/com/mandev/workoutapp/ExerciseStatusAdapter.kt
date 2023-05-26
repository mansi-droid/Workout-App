package com.mandev.workoutapp

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mandev.workoutapp.databinding.ItemExerciseStatusBinding

class ExerciseStatusAdapter(private val items : ArrayList<ExerciseModel>, val context : Context) :
    RecyclerView.Adapter<ExerciseStatusAdapter.ViewHolder>() {

    /**
     * Inflates the item views which is designed in xml layout file
     *
     * create a new
     * {@link ViewHolder} and initializes some private fields to be used by RecyclerView.
     */
    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : ViewHolder {
        val v : ItemExerciseStatusBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_exercise_status, parent, false
        )
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
    override fun onBindViewHolder(holder : ViewHolder, position : Int) {

        val model : ExerciseModel = items[position]

        holder.bindingAdapter.tvItem.text = model.id.toString()

        // Updating the background and text color according to the flags what is in the list.
        // A link to set text color programmatically and same way we can set the drawable background also instead of color.
        // https://stackoverflow.com/questions/8472349/how-to-set-text-color-to-a-text-view-programmatically
        if (model.isSelected == true) {
            holder.bindingAdapter.tvItem.background =
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.item_circular_thin_color_accent_border
                    )
            holder.bindingAdapter.tvItem.setTextColor(
                Color.parseColor("#212121")
            ) // Parse the color string, and return the corresponding color-int.
        } else if (model.isCompleted == true) {
            holder.bindingAdapter.tvItem.background =
                    ContextCompat.getDrawable(context, R.drawable.item_circular_color_accent_background)
            holder.bindingAdapter.tvItem.setTextColor(Color.parseColor("#FFFFFF"))
        } else {
            holder.bindingAdapter.tvItem.background =
                    ContextCompat.getDrawable(context, R.drawable.item_circular_color_gray_background)
            holder.bindingAdapter.tvItem.setTextColor(Color.parseColor("#212121"))
        }
    }

    /**
     * Gets the number of items in the list
     */
    override fun getItemCount() : Int {
        return items.size
    }

    /**
     * A ViewHolder describes an item view and metadata about its place within the RecyclerView.
     */
    inner class ViewHolder(var bindingAdapter : ItemExerciseStatusBinding) :
        RecyclerView.ViewHolder(bindingAdapter.root)
}