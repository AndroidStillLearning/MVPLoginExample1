package com.example.mylynx.mvpexample.login

/**
 * Created by mylynx on 23.05.18.
 */
class LoginModel: LoginActivityMVP.Model {

    private var repository: LoginRepository

    constructor(repository: LoginRepository) {
        this.repository = repository
    }

    override fun createUser(fname: String, lname: String) {
        repository.saveUser(User(fname, lname))
    }

    override fun getUser(): User {
        return repository.getUser()!!
    }

}