package com.example.applicationgastos.ui.NuevoGasto

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.applicationgastos.R

class NvoGastoFragment : Fragment() {

    companion object {
        fun newInstance() = NvoGastoFragment()
    }

    private lateinit var viewModel: NvoGastoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_nvo_gasto, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NvoGastoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}