package com.example.applicationgastos.ui.NuevoGasto

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
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
        //Agrega OPCIONES o items a la Spinner barr
        //id de spinner
        val spinner: Spinner = requireView().findViewById(R.id.spinner_categories)
        //Opciones del Spinner | se agregan a un array tipo string
        val options = arrayOf("Selecciona una categoria", "Alimentos", "Comida", "Entreteniminento", "Pagos y Cuentas", "Ropa y Calzado", "Salud", "Transporte", "Otros")
        //adaptador de los datos del array, para mosgtrar opciones del Spinner
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, options)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }

}