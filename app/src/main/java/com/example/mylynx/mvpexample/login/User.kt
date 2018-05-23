package com.example.mylynx.mvpexample.login

/**
 * Created by mylynx on 23.05.18.
 */
class User {
    var id: Int? = null
    var firstName: String? = null
    var lastName: String? = null

    constructor( firstName: String?, lastName: String?) {

        this.firstName = firstName
        this.lastName = lastName
    }

}