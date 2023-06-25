package com.example.applicationgastos.ui.transporte

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.applicationgastos.R

class TransporteFragment : Fragment() {

    companion object {
        fun newInstance() = TransporteFragment()
    }

    private lateinit var viewModel: TransporteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_transporte, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TransporteViewModel::class.java)
        // TODO: Use the ViewModel
    }

}