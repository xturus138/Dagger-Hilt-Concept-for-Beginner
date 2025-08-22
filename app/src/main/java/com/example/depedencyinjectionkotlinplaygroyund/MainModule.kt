package com.example.depedencyinjectionkotlinplaygroyund

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object MainModule {

    @ActivityScoped
    @Provides
    fun provideEngine(
        @ApplicationContext context: Context,
        @Named("owner") owner: String //injeksi di dalam injeksi
    ): Engine{
        return Engine(context, owner)
    }

}