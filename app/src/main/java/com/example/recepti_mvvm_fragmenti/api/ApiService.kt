package com.example.recepti_mvvm_fragmenti.api


import com.example.recepti_mvvm_fragmenti.model.ResponseArticles
import com.example.recepti_mvvm_fragmenti.util.constants.END_POINT
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(END_POINT)
    suspend fun getRecipe(): Response<ResponseArticles>
}