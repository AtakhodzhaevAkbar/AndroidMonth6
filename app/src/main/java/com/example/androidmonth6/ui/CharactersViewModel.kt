package com.example.androidmonth6.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.androidmonth6.data.Repository
import com.example.androidmonth6.data.model.Character
import com.example.androidmonth6.utils.Resource
import javax.inject.Inject

class CharactersViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    val characters: LiveData<Resource<List<Character>>> = repository.getCharacters()

    fun getCharacterByName(name: String): LiveData<Resource<List<Character>>> {
        return repository.getCharacterByName(name)
    }
}
