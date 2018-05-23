package com.example.mylynx.mvpexample.login

import android.support.annotation.Nullable
import android.text.TextUtils

/**
 * Created by mylynx on 23.05.18.
 */
class LoginActivityPresenter: LoginActivityMVP.Presenter {

    @Nullable
    private var view: LoginActivityMVP.View? = null
    private var model: LoginActivityMVP.Model

    constructor(model: LoginActivityMVP.Model) {
        this.model = model
    }

    override fun setView(view: LoginActivityMVP.View) {
        this.view = view
    }

    override fun loginButtonClicked() {

        if (view != null) {
            if (TextUtils.isEmpty(view!!.getFirstName().trim()) || TextUtils.isEmpty(view!!.getLastName().trim())) {
                view!!.showInputError()

            } else {
                model.createUser(view!!.getFirstName(), view!!.getLastName())
                view!!.showUserSavedMessage()
            }
        }


    }

    override fun getCurrentUser() {
        val user = model.getUser()
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