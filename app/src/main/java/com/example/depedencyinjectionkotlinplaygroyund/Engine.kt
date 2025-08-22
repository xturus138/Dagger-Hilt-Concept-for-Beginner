package com.example.depedencyinjectionkotlinplaygroyund

import android.content.Context

class Engine(private val context: Context, private val owner: String) {

    fun startEngine(){
        println( "${ context.getString(R.string.engine_started)} by $owner")
    }

}