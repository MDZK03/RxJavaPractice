package com.example.rxjavapractice.examples.example5

import android.os.Bundle
import android.widget.Toast
import com.example.rxjavapractice.base.BaseActivity
import com.example.rxjavapractice.base.UiState
import com.example.rxjavapractice.base.example5Description
import com.example.rxjavapractice.databinding.ActivityFlowableExampleBinding

class FlowableExampleActivity : BaseActivity<ActivityFlowableExampleBinding,FlowableExampleViewModel>(
    ActivityFlowableExampleBinding::inflate, FlowableExampleViewModel::class.java
) {
    override fun getToolbarTitle(): String = example5Description

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.uiState().observe(this) { uiState -> if(uiState != null) render(uiState) }
        binding.btnFlowExample.setOnClickListener { viewModel.doSomeWork()}
    }

    override fun onLoad()  = with(binding)  {
        btnFlowExample.isEnabled = false
    }

    override fun onSuccess(uiState: UiState.Success)  = with(binding) {
        btnFlowExample.isEnabled = true
        tvFlowExample.append("onSuccess: value = " + uiState.successMessage)
    }

    override fun onError(uiState: UiState.Error)  = with(binding) {
        Toast.makeText(this@FlowableExampleActivity, uiState.errorMessage, Toast.LENGTH_SHORT).show()
        btnFlowExample.isEnabled = true
    }
}
