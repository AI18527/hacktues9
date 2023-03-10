package com.example.besafeapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.besafeapp.R
import com.example.besafeapp.model.SecurityTopic

class LogInfoAdapter (data:List<String>) :
    RecyclerView.Adapter<LogInfoAdapter.LogInfoViewHolder>() {

    private var safety: List<String> = data

    class LogInfoViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val dataName = view.findViewById<TextView>(R.id.log_title_id)
    }

    override fun getItemCount(): Int = safety.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogInfoViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_loginfo, parent, false)
        return LogInfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: LogInfoViewHolder, position: Int) {
        val item = safety[position]
        holder.dataName.text = item
    }
}