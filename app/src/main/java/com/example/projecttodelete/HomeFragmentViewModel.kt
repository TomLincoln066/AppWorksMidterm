package com.example.projecttodelete

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore

class HomeFragmentViewModel : ViewModel() {

    private val db = FirebaseFirestore.getInstance()
    private val TAG = "willTest"
    val queryStatus = MutableLiveData<Boolean>()

    fun queryMyPost(adapter: HomeFragmentAdapter){
        val articleList = mutableListOf<Article>()

        db.collection("articles")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val createdTime = document["created_time"].toString()
                    val author = document["author"].toString()
                    val tag = document["tag"].toString()
                    val title = document["title"].toString()
                    val content = document["content"].toString()
                    val article = Article(createdTime,author,tag,title,content)
                    articleList.add(article)
                    Log.d(TAG, "${document.id} => ${document.data}")
                }
                Log.d(TAG, "articleList => ${articleList.asReversed()}")
                adapter.submitList(articleList.asReversed())
                queryCompleted()
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
    }

    fun queryCompleted(){
        queryStatus.value = true
    }

}