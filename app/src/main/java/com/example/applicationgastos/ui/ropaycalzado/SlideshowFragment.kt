package com.example.applicationgastos.ui.ropaycalzado

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.applicationgastos.R
import com.example.applicationgastos.databinding.FragmentSlideshowBinding
import com.example.applicationgastos.ui.entretenimiento.GalleryViewModel
import com.example.applicationgastos.ui.ropaycalzado.SlideshowViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}