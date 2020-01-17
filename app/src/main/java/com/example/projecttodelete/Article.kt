package com.example.projecttodelete


import com.squareup.moshi.Json



data class ArticleList(
    val articles :List<Article>
)

data class Article(
    val createdTime: String,
    val author: String,
    val tag: String,
    val title: String,
    val content: String
//    @Json(name = "created_time") val createdTime :String,
//    val author :String,
//    val tag :String,
//    val title :String,
//    val content :String
)