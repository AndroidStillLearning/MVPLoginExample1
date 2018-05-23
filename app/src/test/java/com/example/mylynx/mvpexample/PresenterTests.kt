package com.example.mylynx.mvpexample

import com.example.mylynx.mvpexample.login.LoginActivityMVP
import com.example.mylynx.mvpexample.login.LoginActivityPresenter
import com.example.mylynx.mvpexample.login.MemoryRepository
import com.example.mylynx.mvpexample.login.User
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import org.mockito.Mockito.`when` as whenever

/**
 * Created by mylynx on 23.05.18.
 */

@Suppress("IllegalIdentifier")
class PresenterTests {

    lateinit var mockLoginModel: LoginActivityMVP.Model
    lateinit var mockView: LoginActivityMVP.View
    lateinit var presenter: LoginActivityPresenter

    lateinit var user: User

    @Before
    fun setup() {

        mockLoginModel = mock(LoginActivityMVP.Model::class.java)

        user = User("George", "Washington")

        whenever(mockLoginModel.getUser()).thenReturn(user)

        mockView = mock(LoginActivityMVP.View::class.java)

        presenter = LoginActivityPresenter(mockLoginModel)

        presenter.setView(mockView)

    }


    @Test
    fun `load the user from the repository when valid user is present`() {
        whenever(mockLoginModel.getUser()).thenReturn(user)

        presenter.getCurrentUser()

        verify(mockLoginModel, times(1)).getUser()

        verify(mockView, times(1)).setFirsName("George")
        verify(mockView, times(1)).setLastName("Washington")
        verify(mockView, never()).showUserNotAvailable()
    }

    @Test
    fun `should show error message when user is null`() {

        whenever(mockLoginModel.getUser()).thenReturn(null)

        presenter.getCurrentUser()

        verify(mockLoginModel, times(1)).getUser()

        verify(mockView, never()).setFirsName("George")
        verify(mockView, never()).setLastName("Washington")
        verify(mockView, times(1)).showUserNotAvailable()
    }

    @Test
    fun `should create error message if field are empty`() {

        whenever(mockView.getFirstName()).thenReturn("")

        presenter.loginButtonClicked()

        verify(mockView, times(1)).getFirstName()
        verify(mockView, never()).getLastName()
        verify(mockView, times(1)).showInputError()




        whenever(mockView.getFirstName()).thenReturn("Olga")
        whenever(mockView.getLastName()).thenReturn("")

        presenter.loginButtonClicked()

        verify(mockView, times(2)).getFirstName()
        verify(mockView, times(1)).getLastName()
        verify(mockView, times(2)).showInputError()
    }

    @Test
    fun `should be able to save valid user`() {

        whenever(mockView.getFirstName()).thenReturn("Olga")
        whenever(mockView.getLastName()).thenReturn("Kurylenko")

        presenter.loginButtonClicked()

        verify(mockView, times(2)).getFirstName()
        verify(mockView, times(2)).getLastName()

        verify(mockLoginModel, times(1)).createUser("Olga", "Kurylenko")

        verify(mockView, times(1)).showUserSavedMessage()

    }


}