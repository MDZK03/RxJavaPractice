package com.example.rxjavapractice.view.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.rxjavapractice.base.BaseFragment
import com.example.rxjavapractice.base.UiState
import com.example.rxjavapractice.data.example4Description
import com.example.rxjavapractice.databinding.FragmentCallableExampleBinding
import com.example.rxjavapractice.viewmodel.CallableExampleViewModel

class CallableExampleFragment : BaseFragment<FragmentCallableExampleBinding>(
    FragmentCallableExampleBinding::inflate
) {
    override fun getToolbarTitle(): String = example4Description
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(requireActivity())[CallableExampleViewModel::class.java]
        viewModel.uiState().observe(requireActivity()) { uiState -> if(uiState != null) render(uiState) }
        binding.btnLongOperation.setOnClickListener { viewModel.runCallableExample() }

    }
    override fun onLoad() = with(binding) {
        progressBarClb.visibility = View.VISIBLE
        btnLongOperation.isEnabled = false
        tvMessageArea.append("\n" +"Progressbar visible" + "\n")
        Toast.makeText(requireActivity(), "Please wait a few seconds", Toast.LENGTH_SHORT).show()
    }

    override fun onSuccess(uiState: UiState.Success) = with(binding) {
        progressBarClb.visibility = View.GONE
        btnLongOperation.isEnabled = true
        tvMessageArea.append("\n" + "onNext: " + uiState.successMessage + "\n")
        tvMessageArea.append("\n" + "onComplete: ")
        tvMessageArea.append("Hiding Progressbar" + "\n")
    }

    override fun onError(uiState: UiState.Error) = with(binding) {
        Toast.makeText(requireActivity(), uiState.errorMessage, Toast.LENGTH_SHORT).show()
        progressBarClb.visibility = View.GONE
        btnLongOperation.isEnabled = true
        tvMessageArea.append("\n" + "OnError: ")
        tvMessageArea.append("Hiding Progressbar" + "\n")
    }
}