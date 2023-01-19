package com.example.jetpackcomposeinstagram.data

import javax.inject.Inject

class LoginService @Inject constructor(
    val loginclient: LoginClient,
) {

    suspend fun doLogin() { loginclient.doLogin() }
    /*.doLogin()*/

}