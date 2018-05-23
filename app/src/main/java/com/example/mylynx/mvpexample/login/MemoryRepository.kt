package com.example.mylynx.mvpexample.login

/**
 * Created by mylynx on 23.05.18.
 */
class MemoryRepository: LoginRepository {
    private var user: User? = null

    override fun getUser(): User? {
        if (user == null) {
            user = User("George", "Washington")
            user!!.id = 0
        }

        return user


    }

    override fun saveUser(user: User) {
        if (user == null) {
            this.user = getUser()!!
        }

        this.user = user

    }
}