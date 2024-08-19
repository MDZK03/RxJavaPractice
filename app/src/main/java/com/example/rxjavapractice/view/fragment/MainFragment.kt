package com.example.rxjavapractice.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rxjavapractice.R
import com.example.rxjavapractice.base.BaseFragment
import com.example.rxjavapractice.data.Example
import com.example.rxjavapractice.base.ExampleAdapter
import com.example.rxjavapractice.base.UiState
import com.example.rxjavapractice.data.exampleList
import com.example.rxjavapractice.databinding.FragmentMainBinding

class MainFragment : BaseFragment<FragmentMainBinding>(
    FragmentMainBinding::inflate,
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
        requireActivity().supportFragmentManager
            .commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_main,clickedExample.targetFragment)
                addToBackStack("replace")
                remove(MainFragment())
            }
    }

    override fun getToolbarTitle(): String = "RxJavaExamples"
    override fun onLoad() {
        TODO("Not yet implemented")
    }

    override fun onSuccess(uiState: UiState.Success) {
        TODO("Not yet implemented")
    }

    override fun onError(uiState: UiState.Error) {
        TODO("Not yet implemented")
    }
}