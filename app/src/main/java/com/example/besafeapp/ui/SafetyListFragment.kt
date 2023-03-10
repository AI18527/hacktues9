package com.example.besafeapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.besafeapp.data.Datasource
import com.example.besafeapp.databinding.FragmentSafetyListBinding
import org.json.JSONObject
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter


class SafetyListFragment : Fragment(), CheckboxListener {

    private var _binding: FragmentSafetyListBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSafetyListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.safetyListRV
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = SafetyListAdapter(Datasource().loadTopics(), this)

        binding.calcBtnId.setOnClickListener {

        }

        binding.calcBtnId.setOnClickListener{
            Log.d("TAG","Hello");
        }

        binding.safetyScoreId.text = "score"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun isChecked(id:Int, flag:Boolean){
        jsonObject.put(id.toString(), Boolean)
    }

    companion object{
        const val FILE_NAME = "safetyCheck.json"
        val jsonObject = JSONObject()
    }
}

interface CheckboxListener{
    fun isChecked(id:Int, flag:Boolean)
}