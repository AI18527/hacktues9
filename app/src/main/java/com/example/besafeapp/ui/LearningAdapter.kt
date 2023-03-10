package com.example.besafeapp.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.besafeapp.R
import com.example.besafeapp.model.SecurityTopic
import org.json.JSONObject

class LearningAdapter(data:List<SecurityTopic>) :
    RecyclerView.Adapter<LearningAdapter.LearningViewHolder>() {

        private var safety: List<SecurityTopic> = data

        class LearningViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
            val topicName = view.findViewById<TextView>(R.id.topic_name_id)
            val topicDescription = view.findViewById<TextView>(R.id.expandable_content)
            val expandableContentLayount = view.findViewById<LinearLayout>(R.id.expandable_layout)
            val seeMoreBtn = view.findViewById<ImageButton>(R.id.see_more_btn)
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
            holder.topicName.text = item.topic
            holder.topicDescription.text = item.info

            holder.seeMoreBtn.setOnClickListener {
                if (holder.expandableContentLayount.visibility == View.GONE) {
                    holder.expandableContentLayount.visibility = View.VISIBLE
                    holder.seeMoreBtn.rotation = 180f
                } else {
                    holder.expandableContentLayount.visibility = View.GONE
                    holder.seeMoreBtn.rotation = 0f
                }
            }
        }
}