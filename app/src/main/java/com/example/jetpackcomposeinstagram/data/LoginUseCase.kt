package com.example.jetpackcomposeinstagram.data

import com.example.jetpackcomposeinstagram.data.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository : LoginRepository){
    suspend operator fun invoke(user:String, password:String){
        return repository.doLogin(user,password)
    }
}