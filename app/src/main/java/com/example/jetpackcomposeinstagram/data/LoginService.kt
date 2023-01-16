package com.example.jetpackcomposeinstagram.data

import javax.inject.Inject

class LoginService @Inject constructor(
    val loginclient: LoginClient,
) {

    suspend fun doLogin() { loginclient.doLogin() }
    /*retrofit.provideLoginRetrofitService().create(LoginClient::class.java).doLogin()*/

}