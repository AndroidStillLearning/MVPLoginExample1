package com.example.mylynx.mvpexample.login

import android.support.annotation.Nullable
import android.text.TextUtils

/**
 * Created by mylynx on 23.05.18.
 */
class LoginActivityPresenter(@Nullable private var model: LoginActivityMVP.Model): LoginActivityMVP.Presenter {

    @Nullable
    private var view: LoginActivityMVP.View? = null


    override fun setView(view: LoginActivityMVP.View) {
        this.view = view
    }

    override fun loginButtonClicked() {

        if (view != null) {
            if ((view!!.getFirstName().trim() == "") || (view!!.getLastName().trim() == "")) {
                view!!.showInputError()

            } else {
                model.createUser(view!!.getFirstName(), view!!.getLastName())
                view!!.showUserSavedMessage()
            }
        }


    }


    override fun getCurrentUser() {
        val user: User? = model.getUser()
            if (user == null) {
                if (view != null) {
                    view!!.showUserNotAvailable()
                }
            } else {
                if (view != null) {
                    view!!.setFirsName(user.firstName!!)
                    view!!.setLastName(user.lastName!!)
                }
            }

    }



}