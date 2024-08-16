package com.example.rxjavapractice.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rxjavapractice.R
import com.example.rxjavapractice.base.BaseFragment
import com.example.rxjavapractice.base.UiState
import com.example.rxjavapractice.base.example1Description
import com.example.rxjavapractice.databinding.FragmentRxJavaSimpleBinding
import com.example.rxjavapractice.viewmodel.RxJavaSimpleViewModel

class RxJavaSimpleFragment : BaseFragment<FragmentRxJavaSimpleBinding, RxJavaSimpleViewModel>(
    FragmentRxJavaSimpleBinding::inflate, RxJavaSimpleViewModel::class.java
) {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_rx_java_simple, container, false)
    }

    override fun getToolbarTitle(): String = example1Description

}