package com.example.nambaone.ui.photo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nambaone.data.model.RickAndMorty
import com.example.nambaone.data.repo.RickiAndMortyRepository
import com.example.nambaone.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(var rickiAndMortyRepository: RickiAndMortyRepository) : BaseViewModel() {

    val rickAndMortyData by lazy { MutableLiveData<RickAndMorty>() }

//    Помимо передачи обьекта через аргументы можно передать лишь id b получить объект по в id
//    fun getRickAndMorty(id : Int){
//        scope.launch {
//            try {
//                setLoaderData(true)
//                val response = rickiAndMortyRepository.getById(id)
//                setRickAndMorty(response)
//                setLoaderData(false)
//            }catch (e : Exception){
//                e.stackTrace
//                setLoaderData(false)
//                setErrorMessageData(e.message)
//            }
//        }
//    }

//    private suspend fun setRickAndMorty(rickAndMorty: RickAndMorty) : LiveData<RickAndMorty>{
//        withContext(Dispatchers.Main){
//            rickAndMortyData.value = rickAndMorty
//        }
//        return rickAndMortyData
//    }
}