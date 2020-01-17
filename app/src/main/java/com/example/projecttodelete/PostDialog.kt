package com.example.projecttodelete

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.projecttodelete.databinding.DialogPostBinding
import java.text.SimpleDateFormat

//class PostDialog: DialogFragment() {
//
//    private val viewModel: PostDialogViewModel by lazy {
//        ViewModelProviders.of(this).get(PostDialogViewModel::class.java)
//    }
//    lateinit var binding: DialogPostBinding
//
//    val TAG = "WillTest"
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val binding = DialogPostBinding.inflate(inflater, container, false)
//
//        binding.viewModel = viewModel
//        binding.lifecycleOwner = this
//
//        binding.buttonPostArticle.setOnClickListener {
//            val editTitle = viewModel.editTitle.value
////            val editTag = viewModel.editTag.value
//            val editTag = viewModel.tagSelected.value
//            val editContent = viewModel.editContent.value
//
//            if(editTitle == null || editTitle.trim().isEmpty()
//                ||editTag == null || editTag.trim().isEmpty()
//                || editContent == null || editContent.trim().isEmpty()){
//
//                Toast.makeText(context,"Title、Tag、Content can't be blank",Toast.LENGTH_SHORT).show()
//
//            }else{
//
//                viewModel.articlePost(editTitle,"Will",editTag,convertLongToDateString(System.currentTimeMillis()),editContent)
//
//            }
//        }
//
//        viewModel.postStatus.observe(this, Observer {
//            dismiss()
//        })
//
//        binding.spinnerTag.onItemSelectedListener =
//            object : AdapterView.OnItemSelectedListener {
//                override fun onNothingSelected(parent: AdapterView<*>?) {
//                    viewModel.tagSelected.value = "Lovely"
//                }
//
//                override fun onItemSelected(
//                    parent: AdapterView<*>?,
//                    view: View?,
//                    position: Int,
//                    id: Long
//                ) {
//                    when (position) {
//                        0 -> {
//                            viewModel.tagSelected.value = "Lovely"
//                        }
//                        1 -> {
//                            viewModel.tagSelected.value = "Talk"
//                        }
//                        2 -> {
//                            viewModel.tagSelected.value = "Lie"
//                        }
//                        3 -> {
//                            viewModel.tagSelected.value = "WorkLife"
//                        }
//                    }
//                }
//            }
//
//        return binding.root
//    }
//
//
//    private fun convertLongToDateString(systemTime: Long): String {
//        return SimpleDateFormat("MMM-dd-yyyy HH:mm:ss")
//            .format(systemTime).toString()
//    }
//}