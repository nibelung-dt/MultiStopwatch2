package com.example.multistopwatch2.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory

class StopwatchViewModel: ViewModel() {
  //  private val _seconds = MutableLiveData(0)
// private val myRepository: MyRepository
// private val seconds: Int
private val _seconds = MutableLiveData<Int>()
    // val seconds : LiveData<Int> = 0
    /*
    val seconds: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

     */

    companion object {
        val seconds: Int = 0
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val seconds = 0
                //val myRepository = (this[APPLICATION_KEY] as MyApplication).myRepository
                StopwatchViewModel(
                    seconds = seconds
                )
            }
        }
    }



}