package com.example.applicationgastos.ui

import android.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.room.util.newStringBuilder
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
            //findNavController().navigate(R.id.action_closeFragment_to_loginFragment)

            val builder = AlertDialog.Builder(requireContext())
            builder.setMessage("Quieres cerrar de la aplicación")
                .setTitle("Salir")
                .setCancelable(false)
                .setPositiveButton("Salir"){ dialog, id->
                    activity?.finish();
                }
                .setNegativeButton("No") { dialog, id ->
                    dialog.cancel()
                    findNavController().navigate(R.id.action_closeFragment_to_loginFragment)
                }

            val alert = builder.create()
            alert.show()
        }
        // TODO: Use the ViewModel
    }

}