package com.example.mylynx.mvpexample.login

import dagger.Module
import dagger.Provides

/**
 * Created by mylynx on 23.05.18.
 */
@Module
class LoginModule {

    @Provides
    fun provideLoginActivityPresenter(model: LoginActivityMVP.Model): LoginActivityMVP.Presenter {
        return LoginActivityPresenter(model)
    }

    @Provides
    fun provideLoginActivityModel(repository: LoginRepository): LoginActivityMVP.Model {
        return LoginModel(repository)
    }

    @Provides
    fun provideLoginRepository(): LoginRepository {
        return MemoryRepository()
    }



}