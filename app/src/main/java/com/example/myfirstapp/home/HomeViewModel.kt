package com.example.myfirstapp.home

import android.annotation.SuppressLint
import android.graphics.Color
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myfirstapp.Article
import com.example.myfirstapp.NewsService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.await
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import kotlin.random.Random


class HomeViewModel : ViewModel() {

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
    var sortFlag = mutableStateOf(true)

    @SuppressLint("MutableCollectionMutableState")
    var data = mutableStateOf(emptyList<Article>())

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val newsService = retrofit.create<NewsService>()

        viewModelScope.launch {
            val result = newsService.getAllNews("bitcoin", "d528cfea16ae4d96a035870d535b2aba")
            Log.d("tag", "------------------${result.await()}")
            val articles = result.await().articles
            data.value = articles

        }
    }


//    fun refreshData() {
//        data.value = mutableStateOf(emptyList<Article())
//    }
//
//    private fun createList(size: Int) =
//        MutableList(size) {
//
//            Item(
//                id = it,
//                color = colors.random(),
//                key = Random.nextInt(0, 100)
//            )
//
//        }
//
//    fun sortedKey() {
//        val list = mutableListOf<Item>()
//        list.addAll(data.v)
//        if (sortFlag.value) {
//            list.sortBy { it.key }
//        } else {
//            list.sortByDescending { it.key }
//        }
//        sortFlag.value = !sortFlag.value
//        data.value = list
//    }
}

