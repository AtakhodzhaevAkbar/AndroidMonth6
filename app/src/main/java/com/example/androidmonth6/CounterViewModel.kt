package com.example.androidmonth6

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private val counter = Counter()

    private val _counterData = MutableLiveData<Int>().apply { value = counter.getCountResult() }

    val counterData: LiveData<Int> get() = _counterData

    fun updateCounterData(isInc: Boolean) {
        if (isInc) counter.inc() else counter.dec()
        _counterData.value = counter.getCountResult()
    }
}
