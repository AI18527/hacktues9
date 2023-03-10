package com.example.besafeapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.besafeapp.R
import com.example.besafeapp.model.SecurityTopic

// display info add cards
class LearningAdapter(data:List<SecurityTopic>) :
    RecyclerView.Adapter<LearningAdapter.LearningViewHolder>() {

        private var safety: List<SecurityTopic> = data

        class LearningViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
            val topic = view.findViewById<TextView>(R.id.checkBox)!!
            //val text = view.findViewById<TextView>()
        }

        override fun getItemCount(): Int = safety.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearningViewHolder {
            val view =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_learn, parent, false)
            return LearningViewHolder(view)
        }

        override fun onBindViewHolder(holder: LearningViewHolder, position: Int) {
            val item = safety[position]
            holder.topic.text = item.topic
        }
}