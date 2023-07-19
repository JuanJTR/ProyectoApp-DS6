package com.example.applicationgastos.ui.ropaycalzado

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.example.applicationgastos.DB
import com.example.applicationgastos.GastosWithCategory
import com.example.applicationgastos.R
import com.example.applicationgastos.databinding.FragmentSlideshowBinding
import com.example.applicationgastos.ui.entretenimiento.GalleryViewModel
import com.example.applicationgastos.ui.ropaycalzado.SlideshowViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.launch

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null
    private lateinit var viewModel: SlideshowViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel = ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*val textView: TextView = binding.textSlideshow
        slideshowViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        return root
    }

    // Se elimino el método onActivityCreated y se movio el código relacionado
    // con la inicialización del GalleryViewModel al método onViewCreated
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(SlideshowViewModel::class.java)

        // Enlace al fragmento de nuevo registro
        val btnFab = view.findViewById<FloatingActionButton>(R.id.fab)
        btnFab.setOnClickListener {
            findNavController().navigate(R.id.nvoGastoFragment)
        }
        val db = Room.databaseBuilder(
            this.requireContext().applicationContext,
            DB::class.java, "BD"
        ).allowMainThreadQueries().build()

        lifecycleScope.launch {
            val gastos =  db.gastosDAO().getGastosCategory(5)
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}