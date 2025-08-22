package com.example.depedencyinjectionkotlinplaygroyund

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) //SingletonComponent menandakan bahwa modul-modul injeksi ini akan berjalan selama aplikasi ini hidup
object AppModule {

    @Singleton //ini tidak wajib, tapi kalo kita nambahin anotasi ini maka objek engine ini hanya dibuat 1x selama aplikasi ini berjalan
    @Provides //Ini anotasi untuk memberi tahu hilt kalo fungsi ini adalah modul yang harus di inject
    fun provideEngine(): Engine{
        return Engine()
    }

    @Singleton
    @Provides
    @Named("string1") //solusi memakai anotasi Named, untuk membedakan fungsi 1 dengan fungsi 2 jika sama
    fun provideString() = "Ini adalah string yang akan di inject"

    @Singleton
    @Provides
    @Named("string2")
    fun provideString2() = "Ini provideString 2"


}