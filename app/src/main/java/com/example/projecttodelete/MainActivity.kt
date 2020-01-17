package com.example.projecttodelete

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.firestore.FirebaseFirestore

import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.annotation.NonNull
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.firestore.DocumentReference
import com.google.android.gms.tasks.OnSuccessListener

import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log
import androidx.fragment.app.FragmentActivity


import com.google.firebase.firestore.QueryDocumentSnapshot

import com.google.firebase.firestore.QuerySnapshot
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.OnCompleteListener

import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T

import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap


class MainActivity : AppCompatActivity() {


    var TAG = "WillTest"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        fab.setOnClickListener { view ->
            Snackbar.make(view, "Add a Article from FireBase now", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

//            addData3()
            articlePost("title","Will","Life",convertLongToDateString(System.currentTimeMillis()),"content")


        }

        button_get_data.setOnClickListener{view->
            Snackbar.make(view, "Get  Article from FireBase and publish it", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

            getData()
        }


    }


    fun addData3() {

        val db = FirebaseFirestore.getInstance()

        val articles = FirebaseFirestore.getInstance().collection("articles")

        val document = articles.document()

        val data = hashMapOf(
                "author" to hashMapOf(
                "email" to "wayne@school.appworks.tw",
                "id" to "waynechen323",
                "name" to "AKA小安老師"
            ),
            "title" to "IU「亂穿」竟美出新境界！笑稱自己品味奇怪　網笑：靠顏值\n" +
                    "撐住女神氣場 \"",
            "content" to " 南韓歌手IU（李知恩）無論在歌唱方面或是近期的戲劇作品 都有亮眼的成績，但俗話說人無完美、美玉微瑕，曾再跟工作人員的互動影片中坦言 自己品味很奇怪，近日在IG上分享了宛如「媽媽們青春時代的玉女歌手」超復古穿搭 造型，卻意外美出新境界。 " ,
            "createTime" to Calendar.getInstance()
                .timeInMillis,
            "id" to document.id,
            "tag" to "Beauty"
        )

        document.set(data as Map<String,Any>)
//        db.collection(articles.path).add(data as Map<String,Any>)
    }





    fun getData() {

        val db = FirebaseFirestore.getInstance()

        db.collection("articles")
            .get()
            .addOnCompleteListener(OnCompleteListener<QuerySnapshot> { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        Log.d("getData", document.id + " => " + document.data)
                    }
                } else {
                    Log.w(TAG, "Error getting documents.", task.exception)
                }
            })

    }



    private fun articlePost(
        title: String,
        author: String,
        tag: String,
        createdTime: String,
        content: String
    ) {

        val db = FirebaseFirestore.getInstance()

        val user: HashMap<String, Any> = hashMapOf(
            "title" to title,
            "author" to author,
            "tag" to tag,
            "created_time" to createdTime,
            "content" to content
        )

        db.collection("articles")
            .document(createdTime)
            .set(user)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with content_POST:$documentReference")
                Log.d(TAG, "DocumentSnapshot added with content_POST:$title")
                Toast.makeText(applicationContext,"成功送出文章",Toast.LENGTH_SHORT).show()


            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document_POST", e)
            }
    }






    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }



    private fun convertLongToDateString(systemTime: Long): String {
        return SimpleDateFormat("MMM-dd-yyyy HH:mm:ss")
            .format(systemTime).toString()
    }



}





//fun addData() {
//
//    val db = FirebaseFirestore.getInstance()
//
//    // Create a new user with a first and last name
//    val user = HashMap<String, Any>()
//    user.put("first", "Ada")
//    user.put("last", "Lovelace")
//    user.put("born", 1815)
//
//    // Add a new document with a generated ID
//    db.collection("users")
//        .add(user)
//        .addOnSuccessListener { documentReference ->
//            Log.d(
//                TAG,
//                "DocumentSnapshot added with ID: " + documentReference.id
//            )
//        }
//        .addOnFailureListener { e -> Log.w(TAG, "Error adding document", e) }
//
//}
