package com.example.applicationgastos.ui.entretenimiento

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Entretenimiento"
    }
    val text: LiveData<String> = _text
}