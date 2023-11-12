package com.example.myfirstapp

import android.graphics.Color
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {

        val colors = listOf(
        Color.RED,
        Color.GREEN,
        Color.YELLOW,
        Color.BLUE,
        Color.CYAN,
        Color.DKGRAY,
        Color.GRAY,
        Color.LTGRAY,
        Color.MAGENTA,
        Color.TRANSPARENT
    )
    var stateColor = mutableStateOf(colors.random())
    var data = List(100) {

        Item(
            id = it,
            color = stateColor.value

        )
    }
}