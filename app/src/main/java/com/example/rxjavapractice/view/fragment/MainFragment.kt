package com.example.rxjavapractice.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
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
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hideBackButton()
        binding.recyclerView.apply {
            adapter = ExampleAdapter(exampleList, onExampleClickListener)
            hasFixedSize()
            layoutManager = LinearLayoutManager(requireActivity())
        }
    }

    private val onExampleClickListener: (Example) -> Unit = { clickedExample ->
        childFragmentManager.commit {
            setReorderingAllowed(true)
            replace(binding.mainFragment.id,clickedExample.targetFragment)
            binding.mainFragment.visibility = View.GONE
        }
    }

    override fun getToolbarTitle(): String = "RxJavaExamples"
}