package com.example.nambaone.ui.main

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
class HomeViewModel @Inject constructor(var rickiAndMortyRepository: RickiAndMortyRepository): BaseViewModel() {

    val rickAndMortyData : MutableLiveData<ArrayList<RickAndMorty>> by lazy{
        MutableLiveData<ArrayList<RickAndMorty>>()
    }

    fun getData(){
        scope.launch {
            try {
                setLoaderData(true)
                val response = rickiAndMortyRepository.getAll()
                if (response.isNotEmpty()){
                    setData(response)
                }
                setLoaderData(false)
            // При необходимости можно обработать определенный исключения.
//            }catch (e: IOException) {
//                setLoaderData(false)
//                setErrorMessageData("Network error occurred. Try again.")
//            }
//            catch (e: HttpException) {
//                setLoaderData(false)
//                when (e.code()) {
//                    404 -> setErrorMessageData("Data not found")
//                    500 -> setErrorMessageData("Server error. Please try again later.")
//                    else -> setErrorMessageData("An error occurred. Please try again.")
//                }
            }catch (e : Exception){
                e.stackTrace
                setLoaderData(false)
                setErrorMessageData(e.message)
            }
        }
    }

    private suspend fun setData(rickAndMorty: ArrayList<RickAndMorty>) : LiveData<ArrayList<RickAndMorty>>{
        withContext(Dispatchers.Main){
            rickAndMortyData.value = rickAndMorty
        }
        return rickAndMortyData
    }

}