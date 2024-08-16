package com.example.rxjavapractice.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rxjavapractice.R
import com.example.rxjavapractice.base.BaseFragment
import com.example.rxjavapractice.base.example3Description
import com.example.rxjavapractice.databinding.FragmentBookBinding
import com.example.rxjavapractice.viewmodel.BookViewModel

class BookFragment : BaseFragment<FragmentBookBinding, BookViewModel>(
    FragmentBookBinding::inflate, BookViewModel::class.java
){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book, container, false)
    }

    override fun getToolbarTitle(): String = example3Description
}