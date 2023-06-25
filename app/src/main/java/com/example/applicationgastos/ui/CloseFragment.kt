package com.example.applicationgastos.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.applicationgastos.R

class CloseFragment : Fragment() {

    companion object {
        fun newInstance() = CloseFragment()
    }

    private lateinit var viewModel: CloseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_close, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CloseViewModel::class.java)

        val btnsingoff = requireView().findViewById<Button>(R.id.signoff)//registrarse
        btnsingoff.setOnClickListener {
            findNavController().navigate(R.id.action_closeFragment_to_loginFragment)
        }
        // TODO: Use the ViewModel
    }

}