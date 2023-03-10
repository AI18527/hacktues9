package com.example.besafeapp.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.example.besafeapp.R
import com.example.besafeapp.model.SecurityTopic
import org.json.JSONObject

class SafetyListAdapter(data:List<SecurityTopic>, json: JSONObject, private val listener:CheckboxListener) :
        RecyclerView.Adapter<SafetyListAdapter.SafetyListViewHolder>() {

    private var safety: List<SecurityTopic> = data
    private var userCheck = json

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
        holder.checkBox.text = item.topic

        if (userCheck.getBoolean(item.id.toString())) {
            holder.checkBox.isChecked = true
            map[item.id.toString()] = true
        }
        else{
            map[item.id.toString()] = false
        }

        Log.d("TAG", map.toString())

        holder.checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            map[item.id.toString()] = isChecked
            listener.isChecked(map)
        }
    }

    companion object{
        var map = mutableMapOf<String, Boolean>()
    }
}