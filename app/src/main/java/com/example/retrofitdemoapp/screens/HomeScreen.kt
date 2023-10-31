package com.example.retrofitdemoapp.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.retrofitdemoapp.components.Posts
import com.example.retrofitdemoapp.ui.theme.RetrofitDemoAppTheme


@Composable
fun HomeScreen(viewModel: PostViewModel = hiltViewModel()) {
    Posts(viewModel)

}

