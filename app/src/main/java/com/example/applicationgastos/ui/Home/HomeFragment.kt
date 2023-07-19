package com.example.applicationgastos.ui.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.applicationgastos.DB
import com.example.applicationgastos.R
import com.example.applicationgastos.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val db = Room.databaseBuilder(
            this.requireContext().applicationContext,
            DB::class.java, "BD"
        ).allowMainThreadQueries().build()
        val recyclerView = root.findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = CustomAdapter(this.requireContext().applicationContext, db)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        return root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}