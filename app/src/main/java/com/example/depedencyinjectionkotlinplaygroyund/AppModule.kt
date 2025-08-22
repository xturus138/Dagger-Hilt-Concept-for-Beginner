package com.example.depedencyinjectionkotlinplaygroyund

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) //SingletonComponent menandakan bahwa modul-modul injeksi ini akan berjalan selama aplikasi ini hidup
object AppModule {


    @Provides
    fun provideEngine(
        @ApplicationContext context: Context,
        @Named("owner") owner: String //injeksi di dalam injeksi
    ): Engine{
        return Engine(context, owner)
    }

    @Singleton
    @Provides
    @Named("owner")
    fun ProvidesOwner() = "Raditya"

    @Singleton
    @Provides
    @Named("string1") //solusi memakai anotasi Named, untuk membedakan fungsi 1 dengan fungsi 2 jika sama
    fun provideString() = "Ini adalah string yang akan di inject"

    @Singleton
    @Provides
    @Named("string2")
    fun provideString2() = "Ini provideString 2"


}