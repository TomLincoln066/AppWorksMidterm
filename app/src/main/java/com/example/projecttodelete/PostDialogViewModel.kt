package com.example.projecttodelete

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore

//class PostDialogViewModel : ViewModel() {
//    val TAG = "WillTest"
//    val editTitle = MutableLiveData<String>()
//    val editTag = MutableLiveData<String>()
//    val editContent = MutableLiveData<String>()
//    val tagSelected = MutableLiveData<String>()
//    val postStatus = MutableLiveData<Boolean>()
//
//    fun articlePost(
//        title: String,
//        author: String,
//        tag: String,
//        createdTime: String,
//        content: String
//    ) {
//        val user: HashMap<String, Any> = hashMapOf(
//            "title" to title,
//            "author" to author,
//            "tag" to tag,
//            "created_time" to createdTime,
//            "content" to content
//        )
//// Add a new document with a generated ID
//        val db = FirebaseFirestore.getInstance()
//        db.collection("articles")
//            .document(createdTime)
//            .set(user)
//            .addOnSuccessListener { documentReference ->
//                Log.d(TAG, "DocumentSnapshot added with content_POST:$title")
//                Toast.makeText(.context,"send Success", Toast.LENGTH_SHORT).show()
//                postCompleted()
//            }
//            .addOnFailureListener { e ->
//                Log.w(TAG, "Error adding document_POST", e)
//            }
//    }
//
//    private fun postCompleted(){
//        postStatus.value = true
//    }
//
//}