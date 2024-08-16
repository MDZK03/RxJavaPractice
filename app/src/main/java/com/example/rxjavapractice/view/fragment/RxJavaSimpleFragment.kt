package com.example.rxjavapractice.view.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.rxjavapractice.base.BaseFragment
import com.example.rxjavapractice.base.UiState
import com.example.rxjavapractice.base.example1Description
import com.example.rxjavapractice.databinding.FragmentRxJavaSimpleBinding
import com.example.rxjavapractice.viewmodel.RxJavaSimpleViewModel

class RxJavaSimpleFragment : BaseFragment<FragmentRxJavaSimpleBinding>(
    FragmentRxJavaSimpleBinding::inflate
) {
    override fun getToolbarTitle(): String = example1Description
    private lateinit var viewModel: RxJavaSimpleViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[RxJavaSimpleViewModel::class.java]
        viewModel.uiState().observe(requireActivity()) { uiState -> if(uiState != null) render(uiState) }
        binding.btnServer.setOnClickListener { viewModel.runSimpleRxExample() }
    }

    override fun onLoad() = with(binding) {
        Toast.makeText(requireActivity(), "Please wait a few seconds", Toast.LENGTH_SHORT).show()
        progressbarRx.visibility = View.VISIBLE
        btnServer.isEnabled = false
    }

    override fun onSuccess(uiState: UiState.Success) = with(binding) {
        progressbarRx.visibility = View.GONE
        btnServer.isEnabled = true
        tvResult.text = uiState.successMessage
    }

    override fun onError(uiState: UiState.Error) = with(binding) {
        Toast.makeText(requireActivity(), uiState.errorMessage, Toast.LENGTH_SHORT).show()
        progressbarRx.visibility = View.GONE
        btnServer.isEnabled = true
    }
}