package com.example.applicationgastos.ui.comida

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.applicationgastos.R

class ComidaFragment : Fragment() {

    companion object {
        fun newInstance() = ComidaFragment()
    }

    private lateinit var viewModel: ComidaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_comida, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ComidaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}