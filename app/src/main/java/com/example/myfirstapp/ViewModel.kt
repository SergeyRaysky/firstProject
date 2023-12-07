package com.example.myfirstapp

import android.graphics.Color
import android.util.Log
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
        if(!sortFlag.value) {
            val list = mutableListOf<Item>()
            list.addAll(data.value)
            list.sortBy { it.key }
            data.value = list

            Log.d("TAG", "${data.value}")
            sortFlag.value = true
        }
        else  {
            val list = mutableListOf<Item>()
        list.addAll(data.value)
        list.sortByDescending { it.key }
        data.value = list

        Log.d("TAG", "${data.value}")
        sortFlag.value = false
            }
    }
    }

