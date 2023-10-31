package com.example.retrofitdemoapp.repository

import android.util.Log
import com.example.retrofitdemoapp.data.DataOrException
import com.example.retrofitdemoapp.model.PostItem
import com.example.retrofitdemoapp.network.ApiService
import javax.inject.Inject

class PostRepository @Inject constructor(private val api: ApiService) {
    private val dataOrException = DataOrException<ArrayList<PostItem>, Boolean, Exception>()

    suspend fun getAllPost(): DataOrException<ArrayList<PostItem>, Boolean, Exception> {
        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllPost()
            if (dataOrException.data.toString().isNotEmpty()) dataOrException.loading = false

        } catch (exception: Exception) {
            dataOrException.e = exception
            Log.d("EXC", "getAllQuestions: ${dataOrException.e}")
        }
        return dataOrException
    }
}