package com.example.retrofitdemoapp.network

import com.example.retrofitdemoapp.model.Post
import retrofit2.Response
import retrofit2.http.GET
import javax.inject.Singleton


@Singleton
interface ApiService {
@GET("posts")
suspend fun getAllPost():Post
}