package com.example.mylynx.mvpexample.root

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by mylynx on 23.05.18.
 */
@Module
class ApplicationModule {

    private var application: Application

    constructor(application: Application) {
        this.application = application
    }

    @Provides
    @Singleton
    fun provideContext(): Context = application

}