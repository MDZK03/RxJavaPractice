package com.example.rxjavapractice.examples.example3;

import androidx.annotation.NonNull;
import com.example.rxjavapractice.base.UiState;
import com.example.rxjavapractice.utils.Constants;
import android.os.Bundle;
import com.example.rxjavapractice.base.BaseActivity;
import com.example.rxjavapractice.databinding.ActivityBookBinding;

public class BookActivity extends BaseActivity {
    @NonNull
    @Override
    public String getToolbarTitle() {
        return Constants.THIRD_EXAMPLE;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBookBinding bookBinding = ActivityBookBinding.inflate(getLayoutInflater());
        setContentView(bookBinding.getRoot());
    }

    @Override
    public void onLoad() {

    }

    @Override
    public void onSuccess(@NonNull UiState.Success uiState) {

    }

    @Override
    public void onError(@NonNull UiState.Error uiState) {

    }
}