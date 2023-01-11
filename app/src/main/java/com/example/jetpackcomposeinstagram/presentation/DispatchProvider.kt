package com.example.jetpackcomposeinstagram.presentation

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class DispatchProvider @Inject constructor(){
    fun ioDispatch(): CoroutineDispatcher = Dispatchers.IO
    fun defaultDispatch(): CoroutineDispatcher = Dispatchers.Default
    fun unDispatch(): CoroutineDispatcher = Dispatchers.Unconfined
    fun mainDispatch(): CoroutineDispatcher = Dispatchers.Main
}