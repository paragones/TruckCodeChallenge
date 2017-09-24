package com.aragones.paul.truck.ui.dialog

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.aragones.paul.truck.R
import java.util.ArrayList


class DialogAdapter(private val options: List<Pair<String, String>>,
                    private val chooseOption: (Pair<String, String>) -> Unit) : RecyclerView.Adapter<DialogAdapter.ViewHolder>() {
    val subList: ArrayList<Pair<String, String>> = ArrayList()

    init {
        subList.addAll(options)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.list, parent, false))
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val rlList: RelativeLayout = view.findViewById(R.id.rlList) as RelativeLayout
        val content: TextView = view.findViewById(R.id.optionName) as TextView
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position % 2 == 0) holder.rlList.setBackgroundColor(ContextCompat.getColor(holder.content.context, R.color.yellow))
        holder.content.text = subList[position].second
        holder.rlList.setOnClickListener {
            chooseOption(subList[position])
        }
    }

    fun filter(charText: String) {
        subList.clear()
        if (charText.isEmpty()) {
            subList.addAll(options)
        } else {
            subList.addAll(options.filter {
                it.second.contains(charText.capitalize(), true)
            })
        }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = subList.size
}