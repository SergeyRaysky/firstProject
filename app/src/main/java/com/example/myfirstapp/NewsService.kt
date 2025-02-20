package com.example.myfirstapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsService {
    @GET("everything")
    fun getAllNews(@Query("q") query: String, @Query("apiKey") apiKey: String): Call<NewsResponse>
}

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>,
)

class Arc() {
    fun summ(first: Int, second: Int): Int {
        return first + second
    }
}

data class Article(
    val source: Source,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String,
) {


}

data class Source(
    val id: String?,
    val name: String,
)

object Example {
    fun summ(first: Int, second: Int): Int {
        return first + second
    }
}

fun main() {
    var summ1 = Example.summ(1, 2)
    var summ2 = Arc()
    summ2.summ(1, 2)
}

