package com.example.applicationgastos.ui.alimentos

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.applicationgastos.R
import com.example.applicationgastos.ui.Home.HomeFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AlimentosFragment : Fragment() {

    companion object {
        fun newInstance() = AlimentosFragment()
    }

    private lateinit var viewModel: AlimentosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_alimentos, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AlimentosViewModel::class.java)
        // TODO: Use the ViewModel

        //enlace al fragmento de nuevo registro
        val btnfab = requireView().findViewById<FloatingActionButton>(R.id.fab_al_btn)//nuevo

        btnfab.setOnClickListener {
            //se debe escribir el nombre que tiene en el mobile_navigation.xml
            findNavController().navigate(R.id.nvoGastoFragment)

        }    // TODO: Use the ViewModel
    }


}