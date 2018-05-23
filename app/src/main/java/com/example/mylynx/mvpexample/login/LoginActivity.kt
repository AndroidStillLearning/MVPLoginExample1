package com.example.mylynx.mvpexample.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.mylynx.mvpexample.R
import com.example.mylynx.mvpexample.root.App
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), LoginActivityMVP.View {

    var presenter: LoginActivityMVP.Presenter? = null
    @Inject set



    private var firstName: EditText? = null
    private var lastName: EditText? = null
    private var login: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        injectDagger()


        firstName = loginActivity_firstName_editText
        lastName = loginActivity_LastName_editText
        login = loginActivity_login_button

        login!!.setOnClickListener {
            presenter!!.loginButtonClicked()
        }
    }

    private fun injectDagger() {
        App.mInstance.mApplicationComponent.inject(this)
    }

    override fun onResume() {
        super.onResume()
        presenter!!.setView(this)
        presenter!!.getCurrentUser()

    }

    override fun getFirstName(): String {
        return firstName!!.text.toString()
    }

    override fun getLastName(): String {
        return lastName!!.text.toString()
    }

    override fun showUserNotAvailable() {
        Toast.makeText(this, "Error the user is not available", Toast.LENGTH_SHORT).show()
    }

    override fun showInputError() {
        Toast.makeText(this, "First Name or Last Name cannot be empty", Toast.LENGTH_SHORT).show()
    }

    override fun showUserSavedMessage() {
        Toast.makeText(this, "User saved!", Toast.LENGTH_SHORT).show()
    }

    override fun setFirsName(fname: String) {
        firstName!!.setText(fname)
    }

    override fun setLastName(lname: String) {
        lastName!!.setText(lname)
    }
}
