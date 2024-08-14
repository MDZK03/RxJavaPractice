package com.example.rxjavapractice.examples.example5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.rxjavapractice.base.BaseActivity;
import com.example.rxjavapractice.base.UiState;
import com.example.rxjavapractice.databinding.ActivityFlowableExampleBinding;
import com.example.rxjavapractice.utils.Constants;

public class FlowableExampleActivity extends BaseActivity {
    @NonNull
    @Override
    public String getToolbarTitle() {
        return Constants.FIFTH_EXAMPLE;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFlowableExampleBinding flBinding = ActivityFlowableExampleBinding.inflate(getLayoutInflater());
        setContentView(flBinding.getRoot());
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
