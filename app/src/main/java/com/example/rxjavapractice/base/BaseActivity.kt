package com.example.rxjavapractice.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<B: ViewBinding, V: BaseViewModel<UiState>>(
    private val bindingFactory: (LayoutInflater) -> B,
    private val vmClass: Class<V>
) : ToolbarActivity() {
    lateinit var binding: B
    lateinit var viewModel: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindingFactory(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[vmClass]
    }

    fun render(uiState: UiState) {
        when (uiState) {
            is UiState.Loading -> {
                onLoad()
            }
            is UiState.Success -> {
                onSuccess(uiState)
            }
            is UiState.Error -> {
                onError(uiState)
            }
        }
    }
    abstract fun onLoad()
    abstract fun onSuccess(uiState: UiState.Success)
    abstract fun onError(uiState: UiState.Error)
}