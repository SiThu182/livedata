package com.example.colorchangelivedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ColorChangerViewModel : ViewModel(){
    val colorResource = MutableLiveData<Int>()

    init {
        colorResource.value = 0xfff
    }
}