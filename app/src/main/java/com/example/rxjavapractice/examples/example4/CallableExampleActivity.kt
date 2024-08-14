package com.example.rxjavapractice.examples.example4

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.rxjavapractice.base.BaseActivity
import com.example.rxjavapractice.base.UiState
import com.example.rxjavapractice.base.example4Description
import com.example.rxjavapractice.databinding.ActivityCallableExampleBinding

class CallableExampleActivity : BaseActivity<ActivityCallableExampleBinding, CallableExampleViewModel>(
    ActivityCallableExampleBinding::inflate,
    CallableExampleViewModel::class.java
) {
    override fun getToolbarTitle(): String = example4Description

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.uiState().observe(this) { uiState -> if(uiState != null) render(uiState) }
        binding.btnLongOperation.setOnClickListener { viewModel.runCallableExample() }
    }

    override fun onLoad() = with(binding) {
        progressBarClb.visibility = View.VISIBLE
        btnLongOperation.isEnabled = false
        tvMessageArea.append("\n" +"Progressbar visible" + "\n")
    }

    override fun onSuccess(uiState: UiState.Success) = with(binding) {
        Toast.makeText(this@CallableExampleActivity, "Please wait a few seconds", Toast.LENGTH_SHORT).show()
        progressBarClb.visibility = View.GONE
        btnLongOperation.isEnabled = true
        tvMessageArea.append("\n" + "onNext: " + uiState.successMessage + "\n")
        tvMessageArea.append("\n" + "onComplete: ")
        tvMessageArea.append("Hiding Progressbar" + "\n")
    }

    override fun onError(uiState: UiState.Error) = with(binding) {
        Toast.makeText(this@CallableExampleActivity, uiState.errorMessage, Toast.LENGTH_SHORT).show()
        progressBarClb.visibility = View.GONE
        btnLongOperation.isEnabled = true
        tvMessageArea.append("\n" + "OnError: ")
        tvMessageArea.append("Hiding Progressbar" + "\n")
    }
}
