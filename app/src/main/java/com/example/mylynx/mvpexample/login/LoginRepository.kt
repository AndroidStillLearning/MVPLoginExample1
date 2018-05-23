package com.example.mylynx.mvpexample.login

/**
 * Created by mylynx on 23.05.18.
 */
interface LoginRepository {

    fun getUser(): User?

    fun saveUser(user: User)
}