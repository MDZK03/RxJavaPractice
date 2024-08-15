package com.example.rxjavafragment.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rxjavapractice.base.BaseFragment
import com.example.rxjavapractice.base.example1Description
import com.example.rxjavafragment.databinding.FragmentRxJavaSimpleBinding
import com.example.rxjavafragment.viewmodel.RxJavaSimpleViewModel

class RxJavaSimpleFragment : BaseFragment<FragmentRxJavaSimpleBinding, RxJavaSimpleViewModel>(
    FragmentRxJavaSimpleBinding::inflate,
    RxJavaSimpleViewModel::class.java
) {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding?.root
    }



    override fun getToolbarTitle(): String = example1Description
}