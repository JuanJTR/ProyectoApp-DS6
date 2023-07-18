package com.example.applicationgastos.ui.otros

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.applicationgastos.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class OtrosFragment : Fragment() {

    companion object {
        fun newInstance() = OtrosFragment()
    }

    private lateinit var viewModel: OtrosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_otros, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(OtrosViewModel::class.java)
        // TODO: Use the ViewModel

        val btnfab = requireView().findViewById<FloatingActionButton>(R.id.fab)//nuevo

        btnfab.setOnClickListener {
            //se debe escribir el nombre que tiene en el mobile_navigation.xml
            findNavController().navigate(R.id.nvoGastoFragment)

        }    // TODO: Use the ViewModel
    }

}