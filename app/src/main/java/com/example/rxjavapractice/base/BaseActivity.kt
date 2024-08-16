package com.example.rxjavapractice.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<B: ViewBinding, V: BaseViewModel<UiState>>(
    private val bindingFactory: (LayoutInflater) -> B,
    private val vmClass: Class<V>
) : AppCompatActivity() {
    protected lateinit var binding: B
    protected lateinit var viewModel: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindingFactory(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[vmClass]
    }
}