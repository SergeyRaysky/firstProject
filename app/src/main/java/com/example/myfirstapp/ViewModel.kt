package com.example.myfirstapp

import android.graphics.Color
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class HomeViewModel: ViewModel() {

        private  val colors = listOf(
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
    var sortFlag = mutableStateOf(false)

    var data = mutableStateOf( createList(10))
    fun refreshData(){
        data.value = createList(10)
    }

    private fun createList(size: Int)=
        MutableList(size) {

            Item(
                id = it,
                color = colors.random(),
                key = Random.nextInt(0,100)
            )

        }

    fun sortedKey(){
        val list = mutableListOf<Item>()
        list.addAll(data.value)
        if(!sortFlag.value) {
            list.sortBy { it.key }
            sortFlag.value = true
        }
        else  {
        list.sortByDescending { it.key }
        sortFlag.value = false
            }
        data.value = list
    }
    }

