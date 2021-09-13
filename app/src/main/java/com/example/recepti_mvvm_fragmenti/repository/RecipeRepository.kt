package com.example.recepti_mvvm_fragmenti.repository

import com.example.recepti_mvvm_fragmenti.api.ApiService
import javax.inject.Inject

class RecipeRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getRecipe() = apiService.getRecipe()


}