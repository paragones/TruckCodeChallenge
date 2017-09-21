package com.aragones.paul.truck.ui.dialog

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import com.aragones.paul.truck.R


class DialogAdapter(private val catFacts: List<String>,
                    private val shareCatFact: (String) -> Unit) : RecyclerView.Adapter<DialogAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.facts_view, parent, false))
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val content: TextView = view.findViewById(R.id.cat_fact_content) as TextView
        val seekBar: SeekBar = view.findViewById(R.id.seek_bar) as SeekBar
        val shareButton: ImageView = view.findViewById(R.id.share_button) as ImageView
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.content.text = catFacts[position].content
        holder.shareButton.setOnClickListener {
            shareCatFact(holder.content.text.toString())
        }
    }

    override fun getItemCount(): Int = catFacts.size
}