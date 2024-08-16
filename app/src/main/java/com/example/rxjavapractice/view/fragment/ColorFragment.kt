package com.example.rxjavapractice.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rxjavapractice.R
import com.example.rxjavapractice.base.BaseFragment
import com.example.rxjavapractice.base.example2Description
import com.example.rxjavapractice.databinding.FragmentColorBinding
import com.example.rxjavapractice.viewmodel.ColorViewModel

class ColorFragment : BaseFragment<FragmentColorBinding, ColorViewModel>(
    FragmentColorBinding::inflate, ColorViewModel::class.java
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color, container, false)
    }

    override fun getToolbarTitle(): String = example2Description

    companion object {
    }
}