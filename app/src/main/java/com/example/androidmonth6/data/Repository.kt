package com.example.androidmonth6.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.androidmonth6.api.ApiService
import com.example.androidmonth6.data.model.BaseResponce
import com.example.androidmonth6.data.model.Character
import com.example.androidmonth6.utils.Resource
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class Repository @Inject constructor(
    private val api: ApiService,
) {
    fun getCharacters(): LiveData<Resource<List<Character>>> = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            val response = api.getCharacters()
            emit(Resource.Success(response.results))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown Error"))
        }
    }

    fun getCharacterByName(name: String): LiveData<Resource<List<Character>>> = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            val response = api.getCharacters()
            val filteredCharacters = response.results.filter {
                it.name.toLowerCase().contains(name.toLowerCase())
            }
            emit(Resource.Success(filteredCharacters))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown Error"))
        }
    }
}
