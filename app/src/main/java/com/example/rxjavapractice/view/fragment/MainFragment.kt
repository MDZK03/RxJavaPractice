package com.example.rxjavapractice.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rxjavapractice.base.BaseFragment
import com.example.rxjavapractice.base.Example
import com.example.rxjavapractice.base.ExampleAdapter
import com.example.rxjavapractice.base.exampleList
import com.example.rxjavapractice.databinding.FragmentMainBinding
import com.example.rxjavapractice.viewmodel.MainFragmentViewModel

class MainFragment : BaseFragment<FragmentMainBinding, MainFragmentViewModel>(
    FragmentMainBinding::inflate,
    MainFragmentViewModel::class.java
) {
    private val onExampleClickListener: (Example) -> Unit = { clickedExample ->
        activity?.supportFragmentManager?.beginTransaction()?.show(clickedExample.targetFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        hideBackButton()
        val view = binding?.recyclerView?.apply {
            adapter = ExampleAdapter(exampleList, onExampleClickListener)
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun getToolbarTitle(): String = "RxJavaExamples"
}