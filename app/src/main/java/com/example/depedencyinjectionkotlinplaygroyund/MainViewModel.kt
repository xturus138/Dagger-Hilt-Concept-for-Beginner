package com.example.depedencyinjectionkotlinplaygroyund

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel //memberitahu hilt bahwa ini adalah view model yang akan di inject oleh hilt
class MainViewModel @Inject constructor(
    private val engine: Engine //kita akan menginject engine di dalam viewmodel
): ViewModel() {

    fun start(){
        engine.startEngine()
    }

}