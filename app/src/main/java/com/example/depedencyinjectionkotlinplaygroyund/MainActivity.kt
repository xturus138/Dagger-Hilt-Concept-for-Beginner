package com.example.depedencyinjectionkotlinplaygroyund

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    //lateinit itu menandakan bahwa variabel ini akan diisi nanti
    @Inject //Anotasi untuk injeksi, jadi ini memberi tahu hilt bahwa variabel ini akan di suntik dengan objek yang dibuat di class module
    lateinit var engine: Engine

    @Inject
//    @Named("string1")
    lateinit var injectedString: String

    @Inject
//    @Named("string2")
    lateinit var injectedString2: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //kalo pake DI, kita hanya tinggal menjalankan saja, tidak usah menginisialisasi terus objek baru
        engine.startEngine()



        println(injectedString) //secara logika, variabel injected string ini tidak akan muncul karena tidak ada value nya ->
        //tetapi karena kita injeksi valuenya di module, maka variabel ini mempunyai sebuah value tanpa perlu kita inisialisasi

        println(injectedString2) //kenapa hasilnya sama dengan variabel injected String? karena konsep inject itu ->
        // artinya, string yang ada di module akan di suntik ke semua variabel bertipe string yang dikasih anotasi Inject. ->
        // Jadi hilt ini tidak akan pandang bulu, selama sebuah variabel bertipe string dan dikasih anotasi Inject ->
        // maka dia akan di inject dengan string yang ada di module.



        //kalo ga pake Depedency Injection
//        val engine = Engine()
//        engine.startEngine()
    }
}