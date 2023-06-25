package com.example.applicationgastos.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.applicationgastos.R

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        /*val btnsignup = requireView().findViewById<Button>(R.id.sigup)//registrarse
        btnsignup.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_nav_home)
        }*/

        val btnlogin = requireView().findViewById<Button>(R.id.log)//registrarse
        btnlogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_nav_home)

        }    // TODO: Use the ViewModel
    }



}