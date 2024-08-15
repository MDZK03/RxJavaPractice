package com.example.rxjavapractice.base

open class UiState {
    class Loading : UiState()
    class Success(val successMessage: String) : UiState()
    class Error(val errorMessage: String) : UiState()
}