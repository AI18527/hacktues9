package com.example.besafeapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.besafeapp.R
import com.example.besafeapp.data.Datasource
import com.example.besafeapp.databinding.FragmentLearningBinding
import com.example.besafeapp.databinding.FragmentSafetyListBinding
import org.json.JSONObject


class LearningFragment : Fragment() {

    private var _binding: FragmentLearningBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLearningBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.learningListRV
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = LearningAdapter(Datasource().loadTopics())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
