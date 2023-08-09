package com.example.nambaone.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

open class BaseViewModel : ViewModel() {

    private val jobs = Job()

    private val coroutineContext: CoroutineContext
        get() = jobs + Dispatchers.IO

    val scope = CoroutineScope(coroutineContext)

    val loader: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    val errorMessageData: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    suspend fun setErrorMessageData(message: String?): LiveData<String> {
        withContext(Dispatchers.Main) {
            errorMessageData.value = message
        }
        return errorMessageData
    }

    suspend fun setLoaderData(isLoad: Boolean): LiveData<Boolean> {
        withContext(Dispatchers.Main) {
            loader.value = isLoad
        }
        return loader
    }
}