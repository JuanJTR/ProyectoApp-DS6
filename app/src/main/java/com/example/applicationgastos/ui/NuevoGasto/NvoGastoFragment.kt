package com.example.applicationgastos.ui.NuevoGasto

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.example.applicationgastos.DB
import com.example.applicationgastos.Gastos
import com.example.applicationgastos.R
import kotlinx.coroutines.launch

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

        val addBtn: Button = requireView().findViewById<Button>(R.id.button_add)
        var categorySelected: String
        var description: String
        var monto: Double
        addBtn.setOnClickListener {
            val category = requireView().findViewById<Spinner>(R.id.spinner_categories)
            val descriptionTxt = requireView().findViewById<EditText>(R.id.editTextDescrip)
            val amountTxt = requireView().findViewById<EditText>(R.id.editTextAmount)
            categorySelected = category.selectedItem.toString()
            description = descriptionTxt.text.toString()
            monto = amountTxt.text.toString().toDouble()
            addData(categorySelected, description, monto)
        }
    }

    private fun addData (category: String, description: String, monto: Double){
        val db = Room.databaseBuilder(
            this.requireContext().applicationContext,
            DB::class.java, "BD"
        ).allowMainThreadQueries().build()
        val categoryID: Int
        when(category){
            "Alimentos" ->{
                categoryID = 1
            }
            "Comida" ->{
                categoryID = 2
            }
            "Entretenimiento" ->{
                categoryID = 3
            }
            "Pagos y Cuentas" ->{
                categoryID = 4
            }
            "Ropa y Calzado" ->{
                categoryID = 5
            }
            "Salud" ->{
                categoryID = 6
            }
            "Transporte" ->{
                categoryID = 7
            }

            "Otros" ->{
            categoryID = 8
            }
            else -> {
                categoryID = 8
            }
        }
        lifecycleScope.launch {
            db.gastosDAO().insertAll(Gastos(categoryID, monto, "19/05/04", description))
            val gastos =  db.gastosDAO().getGastos()
            for (g in gastos){
                println("${g.gastos.monto}, ${g.gastos.fecha}, ${g.gastos.descripcion}, ${g.category}")
            }
        }
        println(categoryID)
    }
}