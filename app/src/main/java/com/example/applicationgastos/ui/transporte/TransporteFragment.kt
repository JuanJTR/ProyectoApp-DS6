package com.example.applicationgastos.ui.transporte

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.example.applicationgastos.DB
import com.example.applicationgastos.GastosWithCategory
import com.example.applicationgastos.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.launch

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

        val btnfab = requireView().findViewById<FloatingActionButton>(R.id.fab)//nuevo

        btnfab.setOnClickListener {
            //se debe escribir el nombre que tiene en el mobile_navigation.xml
            findNavController().navigate(R.id.nvoGastoFragment)

        }
        val db = Room.databaseBuilder(
            this.requireContext().applicationContext,
            DB::class.java, "BD"
        ).allowMainThreadQueries().build()

        lifecycleScope.launch {
            val gastos =  db.gastosDAO().getGastosCategory(7)
            setupTable(gastos)
        }
    }

    private fun setupTable(data: List<GastosWithCategory>){

        val table = requireView().findViewById<TableLayout>(R.id.table)
        for (d in data){
            val tableRow = TableRow(this.requireContext().applicationContext)

            val textView1 = TextView(this.requireContext().applicationContext)
            textView1.text = d.gastos.descripcion
            textView1.setTextAppearance(R.style.TableCellStyle)

            val textView2 = TextView(this.requireContext().applicationContext)
            textView2.text = d.gastos.monto.toString()
            textView2.setTextAppearance(R.style.TableCellStyle)

            val textView3 = TextView(this.requireContext().applicationContext)
            textView3.text = d.gastos.descripcion
            textView3.setTextAppearance(R.style.TableCellStyle)

            val textView4 = TextView(this.requireContext().applicationContext)
            textView4.text = d.gastos.fecha
            textView4.setTextAppearance(R.style.TableCellStyle)


            tableRow.addView(textView1)
            tableRow.addView(textView2)
            tableRow.addView(textView3)
            tableRow.addView(textView4)

            table.addView(tableRow)

            println("${d.gastos.monto}, ${d.gastos.fecha}, ${d.gastos.descripcion}, ${d.category}")
        }
    }

}