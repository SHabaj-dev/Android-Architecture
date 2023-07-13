package com.sbz.livedataexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val liveDataObject = MutableLiveData("This is our example Live Data")

    val liveData: LiveData<String>
        get() = liveDataObject

    fun updateLiveData() {
        liveDataObject.value = "This is another Live Data Example after update"
    }
}