package com.example.rxjavapractice.examples.example4;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import com.example.rxjavapractice.base.BaseActivity;
import com.example.rxjavapractice.base.UiState;
import com.example.rxjavapractice.databinding.ActivityCallableExampleBinding;
import com.example.rxjavapractice.utils.Constants;

public class CallableExampleActivity extends BaseActivity {
    private ActivityCallableExampleBinding callBinding;
    @NonNull
    @Override
    public String getToolbarTitle() {
        return Constants.FOURTH_EXAMPLE;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callBinding = ActivityCallableExampleBinding.inflate(getLayoutInflater());
        setContentView(callBinding.getRoot());

        CallableExampleViewModel viewModel = new CallableExampleViewModel();
        viewModel.uiState().observe(this, uiState -> {
            if (uiState != null) render(uiState);
        });

        callBinding.btnLongOperation.setOnClickListener(v -> viewModel.callableExample());
    }

    @Override
    public void onLoad() {
        callBinding.progressBarClb.setVisibility(View.VISIBLE);
        callBinding.btnLongOperation.setEnabled(false);
        callBinding.messageArea.append("\n" +"Progressbar visible" + "\n");
    }

    @Override
    public void onSuccess(@NonNull UiState.Success uiState) {
        Toast.makeText(this, "Please wait a few seconds", Toast.LENGTH_SHORT).show();
        callBinding.progressBarClb.setVisibility(View.GONE);
        callBinding.btnLongOperation.setEnabled(true);
        callBinding.messageArea.append("\n" + "onNext: " + uiState.getSuccessMessage() + "\n");
        callBinding.messageArea.append("\n" + "onComplete: ");
        callBinding.messageArea.append("Hiding Progressbar" + "\n");
    }

    @Override
    public void onError(@NonNull UiState.Error uiState) {
        Toast.makeText(this, uiState.getErrorMessage(), Toast.LENGTH_SHORT).show();
        callBinding.progressBarClb.setVisibility(View.GONE);
        callBinding.btnLongOperation.setEnabled(true);
        callBinding.messageArea.append("\n" + "OnError: ");
        callBinding.messageArea.append("Hiding Progressbar" + "\n");
    }
}
