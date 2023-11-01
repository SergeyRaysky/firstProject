package com.example.myfirstapp

import android.graphics.Color
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {
  private val colors = listOf(
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
    val data = List(100) {
        Item(
            id = it,
            color = colors.random()
        )
    }
}