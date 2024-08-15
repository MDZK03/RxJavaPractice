package com.example.rxjavapractice.view.activity

import android.os.Bundle
import com.example.rxjavapractice.R
import com.example.rxjavapractice.base.BaseActivity
import com.example.rxjavapractice.base.UiState
import com.example.rxjavapractice.databinding.ActivityMainBinding
import com.example.rxjavapractice.view.fragment.MainFragment
import com.example.rxjavapractice.viewmodel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    ActivityMainBinding::inflate, MainViewModel::class.java,
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

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