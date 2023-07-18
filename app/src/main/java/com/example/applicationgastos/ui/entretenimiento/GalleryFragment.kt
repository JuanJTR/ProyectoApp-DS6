//package com.example.applicationgastos.ui.entretenimiento
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.fragment.app.Fragment
//import androidx.lifecycle.ViewModelProvider
//import androidx.navigation.fragment.findNavController
//import com.example.applicationgastos.R
//import com.example.applicationgastos.databinding.FragmentGalleryBinding
//import com.example.applicationgastos.ui.alimentos.AlimentosViewModel
//import com.google.android.material.floatingactionbutton.FloatingActionButton
//
//class GalleryFragment : Fragment() {
//
//    private var _binding: FragmentGalleryBinding? = null
//
//    // This property is only valid between onCreateView and
//    // onDestroyView.
//    private val binding get() = _binding!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        val galleryViewModel =
//            ViewModelProvider(this).get(GalleryViewModel::class.java)
//
//        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
//        val root: View = binding.root
//
//        return root
//    }
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(GalleryViewModel::class.java)
//        // TODO: Use the ViewModel
//
//        //enlace al fragmento de nuevo registro
//        val btnfab = requireView().findViewById<FloatingActionButton>(R.id.fab_al_btn)//nuevo
//
//        btnfab.setOnClickListener {
//            //se debe escribir el nombre que tiene en el mobile_navigation.xml
//            findNavController().navigate(R.id.nvoGastoFragment)
//
//        }    // TODO: Use the ViewModel
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//}

package com.example.applicationgastos.ui.entretenimiento

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.applicationgastos.R
import com.example.applicationgastos.databinding.FragmentGalleryBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    // Se agrego el GalleryViewModel por medio de... lateinit var viewModel
    private lateinit var viewModel: GalleryViewModel

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel = ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    // Se elimino el método onActivityCreated y se movio el código relacionado
    // con la inicialización del GalleryViewModel al método onViewCreated
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(GalleryViewModel::class.java)

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