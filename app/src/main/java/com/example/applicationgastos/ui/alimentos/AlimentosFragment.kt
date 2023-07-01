package com.example.applicationgastos.ui.alimentos

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.applicationgastos.R
import com.example.applicationgastos.ui.Home.HomeFragment

class AlimentosFragment : Fragment() {

    companion object {
        fun newInstance() = AlimentosFragment()
    }

    private lateinit var viewModel: AlimentosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_alimentos, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AlimentosViewModel::class.java)
        // TODO: Use the ViewModel
    }

//    fun onFabClick(view: View) {
//        // Código para realizar la acción deseada al hacer clic en el FloatingActionButton
//
//        // Por ejemplo, puedes navegar a otro fragmento
//        val nextFragment = HomeFragment()
//        val fragmentManager = requireActivity().supportFragmentManager
//        fragmentManager.beginTransaction()
//            .replace(R.id.nav_home, nextFragment)
//            .addToBackStack(null)
//            .commit()
//    }
}