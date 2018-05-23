package com.example.mylynx.mvpexample.root

import android.app.Application
import com.example.mylynx.mvpexample.login.LoginModule

/**
 * Created by mylynx on 23.05.18.
 */
class App: Application() {

    companion object {
        lateinit var mInstance: App
    }

    lateinit var mApplicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        mInstance = this
        mApplicationComponent = initApplicationComponent()


    }

    private fun initApplicationComponent() : ApplicationComponent {
        return DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .loginModule(LoginModule())
                .build()
    }

}