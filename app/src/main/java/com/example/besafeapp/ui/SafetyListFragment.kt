package com.example.besafeapp.ui

import android.content.Context
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
import java.io.BufferedReader
import java.io.File
import java.io.InputStream
import java.io.InputStreamReader


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
        recyclerView.adapter = SafetyListAdapter(Datasource().loadTopics(), readFile(), this)

        binding.calcBtnId.setOnClickListener{
        }

        binding.safetyScoreId.text = "score"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun isChecked(map: Map<String, Boolean>){
        val json = JSONObject(map)
        writeFile(json.toString())
    }

    companion object{
        const val FILE_NAME = "safetyCheck.txt"
    }

    private fun readFile(): JSONObject{
        val inputStream: InputStream = requireContext().openFileInput(FILE_NAME)
        val reader = BufferedReader(InputStreamReader(inputStream))

        val stringBuilder = StringBuilder()
        var line: String? = reader.readLine()
        while (line != null) {
            stringBuilder.append(line).append("\n")
            line = reader.readLine()
        }
        reader.close()
        return JSONObject(stringBuilder.toString())
    }

    private fun writeFile(string:String){
        requireContext().openFileOutput(FILE_NAME, Context.MODE_PRIVATE).use {
            it.write(string.toByteArray())
        }
    }
}

interface CheckboxListener{
    fun isChecked(map: Map<String, Boolean>)
}