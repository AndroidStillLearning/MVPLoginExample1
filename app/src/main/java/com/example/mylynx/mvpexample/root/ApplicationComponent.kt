package com.example.mylynx.mvpexample.root

import com.example.mylynx.mvpexample.login.LoginActivity
import com.example.mylynx.mvpexample.login.LoginModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by mylynx on 23.05.18.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class, LoginModule::class))
interface ApplicationComponent {

    fun inject(target: LoginActivity)

}