package com.example.mylynx.mvpexample.login

/**
 * Created by mylynx on 23.05.18.
 */
interface LoginActivityMVP {

    interface View {
        fun getFirstName(): String
        fun getLastName(): String

        fun showUserNotAvailable()
        fun showInputError()
        fun showUserSavedMessage()

        fun setFirsName(fname: String)
        fun setLastName(lname: String)
    }

    interface Presenter {

        fun setView(view: LoginActivityMVP.View)

        fun loginButtonClicked()

        fun getCurrentUser()

    }

    interface Model {

        fun createUser(fname: String, lname: String)

        fun getUser(): User

    }

}