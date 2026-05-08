package com.example.algchymns.data.remote

import com.example.algchymns.data.remote.response_models.GetAllHymnsResponse
import retrofit2.http.GET

interface AlgcApiService {
    @GET("api/algc/allHymns")
    suspend fun getAllHymns(): GetAllHymnsResponse
}