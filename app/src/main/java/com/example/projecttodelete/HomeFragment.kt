package com.example.projecttodelete

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.projecttodelete.databinding.FragmentHomeBinding
import com.google.firebase.firestore.FirebaseFirestore

class HomeFragment : Fragment() {
    val db = FirebaseFirestore.getInstance()


    val TAG = "willTest"
    /**
     * Lazily initialize our [HomeViewModel].
     */
    private val viewModel: HomeFragmentViewModel by lazy {
        ViewModelProviders.of(this).get(HomeFragmentViewModel::class.java)
    }

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)

        /*RecyclerViewAdapter*/
        val adapter = HomeFragmentAdapter()
        binding.articleRecycler.adapter =adapter

        /*queryPostFromFireBase*/
        queryPost(adapter)



        return binding.root
    }

    /*queryPostFromFireBase*/
    private fun queryPost(adapter: HomeFragmentAdapter){
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
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
    }
}