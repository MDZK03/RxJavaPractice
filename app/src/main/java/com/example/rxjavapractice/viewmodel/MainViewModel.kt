package com.example.rxjavapractice.viewmodel

import com.example.rxjavapractice.base.BaseViewModel
import com.example.rxjavapractice.base.UiState

class MainViewModel : BaseViewModel<UiState>() {
    fun runApp() {
        uiState.value = UiState.Loading()
        try {
            uiState.value = UiState.Success("Let's start!")
        } catch (e: Exception) {
            uiState.value = UiState.Error("$e")
        }
    }
}