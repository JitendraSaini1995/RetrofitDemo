package com.example.retrofitdemoapp.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitdemoapp.data.DataOrException

import com.example.retrofitdemoapp.model.PostItem

import com.example.retrofitdemoapp.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val repository: PostRepository):ViewModel() {
    val data: MutableState<DataOrException<ArrayList<PostItem>, Boolean, Exception>> =
        mutableStateOf(
            DataOrException(null, true, Exception(""))
        )

    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        viewModelScope.launch {
            data.value.loading = true
            data.value = repository.getAllPost()
            if(data.value.data.toString().isNotEmpty()){
                data.value.loading = false
            }


        }

    }
}