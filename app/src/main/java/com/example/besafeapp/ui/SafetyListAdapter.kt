package com.example.besafeapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.example.besafeapp.R

class SafetyListAdapter() :
        RecyclerView.Adapter<SafetyListAdapter.SafetyListViewHolder>() {

        private var safety: List<String> = arrayListOf("Hello", "Hi", "Hola")

        class SafetyListViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
            val checkBox = view.findViewById<CheckBox>(R.id.checkBox)!!

        }

        override fun getItemCount(): Int = safety.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SafetyListViewHolder {
            val view =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_safety, parent, false)
            return SafetyListViewHolder(view)
        }

        override fun onBindViewHolder(holder: SafetyListViewHolder, position: Int) {
            val item = safety[position]
            holder.checkBox.text = item
        }
    }