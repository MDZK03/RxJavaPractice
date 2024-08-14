package com.example.rxjavapractice.base;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class BaseViewModel<T> extends ViewModel {
    protected MutableLiveData<T> uiState = new MutableLiveData<T>();
    public LiveData<T> uiState() {
        return uiState;
    }
}
