package com.example.rxjavapractice.examples.example1

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.rxjavapractice.base.BaseActivity
import com.example.rxjavapractice.base.UiState
import com.example.rxjavapractice.base.example1Description
import com.example.rxjavapractice.databinding.ActivityRxJavaSimpleBinding

class RxJavaSimpleActivity : BaseActivity<ActivityRxJavaSimpleBinding, RxJavaSimpleViewModel> (
    ActivityRxJavaSimpleBinding::inflate,
    RxJavaSimpleViewModel::class.java
) {
    override fun getToolbarTitle(): String = example1Description

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.uiState().observe(this) { uiState -> if(uiState != null) render(uiState) }
        binding.btnServer.setOnClickListener { viewModel.runSimpleRxExample() }
    }

    override fun onLoad() = with(binding) {
        Toast.makeText(this@RxJavaSimpleActivity, "Please wait a few seconds", Toast.LENGTH_SHORT).show()
        progressbarRx.visibility = View.VISIBLE
        btnServer.isEnabled = false
    }

    override fun onSuccess(uiState: UiState.Success) = with(binding) {
        progressbarRx.visibility = View.GONE
        btnServer.isEnabled = true
        tvResult.text = uiState.successMessage
    }

    override fun onError(uiState: UiState.Error) = with(binding) {
        Toast.makeText(this@RxJavaSimpleActivity, uiState.errorMessage, Toast.LENGTH_SHORT).show()
        progressbarRx.visibility = View.GONE
        btnServer.isEnabled = true
    }
}
