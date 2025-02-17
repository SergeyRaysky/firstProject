package com.example.myfirstapp.detail

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class DetailViewModel(var id: Int, var title: String, var description: String) :
    ViewModel() {
    var detailTitle = mutableStateOf(title)
    var count = mutableIntStateOf(0)
    fun titleOy() {
        detailTitle.value = detailTitle.value + " oy"
        count.intValue = count.intValue+ 1

    }
}