package com.example.rxjavapractice.view.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.rxjavapractice.base.BaseFragment
import com.example.rxjavapractice.base.UiState
import com.example.rxjavapractice.base.example5Description
import com.example.rxjavapractice.databinding.FragmentFlowableExampleBinding
import com.example.rxjavapractice.viewmodel.FlowableExampleViewModel

class FlowableExampleFragment : BaseFragment<FragmentFlowableExampleBinding>(
    FragmentFlowableExampleBinding::inflate
) {
    override fun getToolbarTitle(): String = example5Description
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(requireActivity())[FlowableExampleViewModel::class.java]
        viewModel.uiState().observe(requireActivity()) { uiState -> if(uiState != null) render(uiState) }
        binding.btnFlowExample.setOnClickListener { viewModel.doSomeWork() }
    }
    override fun onLoad() = with(binding) {
        btnFlowExample.isEnabled = false
    }

    override fun onSuccess(uiState: UiState.Success) = with(binding) {
        btnFlowExample.isEnabled = true
        tvFlowExample.append("onSuccess: value = " + uiState.successMessage)
    }

    override fun onError(uiState: UiState.Error) = with(binding) {
        Toast.makeText(requireActivity(), uiState.errorMessage, Toast.LENGTH_SHORT).show()
        btnFlowExample.isEnabled = true
    }
}