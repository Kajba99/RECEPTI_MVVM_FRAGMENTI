package com.example.recepti_mvvm_fragmenti.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recepti_mvvm_fragmenti.model.ResponseArticles
import com.example.recepti_mvvm_fragmenti.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RecipeViewModel @Inject constructor(private val repository: RecipeRepository) : ViewModel(){


    private val _response = MutableLiveData<ResponseArticles>()
    val recipeResponse: LiveData<ResponseArticles> = _response

    init {
        getRecipe()
    }

    private fun getRecipe() = viewModelScope.launch {
        repository.getRecipe().let {  response ->
            if (response.isSuccessful){
                _response.postValue(response.body())
            } else{
                Log.d("response error", "${response.code()}")
            }
        }
    }


}