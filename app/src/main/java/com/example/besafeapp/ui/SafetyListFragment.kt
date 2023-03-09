package com.example.besafeapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.besafeapp.databinding.FragmentSafetyListBinding


class SafetyListFragment : Fragment() {

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
        recyclerView.adapter = SafetyListAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}