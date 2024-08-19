package com.example.rxjavapractice.view.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rxjavapractice.base.BaseFragment
import com.example.rxjavapractice.base.ListAdapter
import com.example.rxjavapractice.base.UiState
import com.example.rxjavapractice.data.colors
import com.example.rxjavapractice.data.example2Description
import com.example.rxjavapractice.databinding.FragmentColorBinding
import com.example.rxjavapractice.viewmodel.ColorViewModel

class ColorFragment : BaseFragment<FragmentColorBinding>(
    FragmentColorBinding::inflate
) {
    private var listAdapter = ListAdapter(colors)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(requireActivity())[ColorViewModel::class.java]
        viewModel.uiState().observe(requireActivity()) { uiState -> if(uiState != null) render(uiState) }
        viewModel.loadColorList()
        binding.colorList.apply {
            adapter = listAdapter
            hasFixedSize()
            layoutManager = LinearLayoutManager(requireActivity())
        }
    }
    override fun getToolbarTitle(): String = example2Description
    override fun onLoad() {
        binding.progressBarColor.visibility = View.VISIBLE
    }

    override fun onSuccess(uiState: UiState.Success) {
        binding.progressBarColor.visibility = View.GONE
    }

    override fun onError(uiState: UiState.Error) {
        binding.progressBarColor.visibility = View.GONE
    }
}