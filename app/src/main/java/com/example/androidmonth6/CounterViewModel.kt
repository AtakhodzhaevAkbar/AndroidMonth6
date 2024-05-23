package com.example.androidmonth6

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private val counter = Counter()
    val counterData=MutableLiveData<Int>()

    fun updateCounterData(isInc:Boolean){
        if(isInc) counter.inc() else counter.dec()
    }
}