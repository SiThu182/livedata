package com.example.colorchangelivedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import java.util.*
import java.util.concurrent.TimeUnit

class TimeChangerViewModel : ViewModel(){
    val timeValue = MutableLiveData<Long>()
    val colorResource = MutableLiveData<Int>()
    init {

        timeValue.value = System.currentTimeMillis()
        colorResource.value = 0xfff

        startTimer()

    }

    private fun startTimer(){
         Observable.interval(2,2 ,TimeUnit.SECONDS)
             .subscribe({
                 timeValue.postValue(System.currentTimeMillis())
             },Throwable::printStackTrace)

    }



}