package com.example.rxjavapractice.examples.example1;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.rxjavapractice.base.BaseActivity;
import com.example.rxjavapractice.base.UiState;
import com.example.rxjavapractice.databinding.ActivityRxJavaSimpleBinding;
import com.example.rxjavapractice.utils.Constants;

public class RxJavaSimpleActivity extends BaseActivity {

    private ActivityRxJavaSimpleBinding rxBinding;

    @NonNull
    @Override
    public String getToolbarTitle() {
        return Constants.FIRST_EXAMPLE;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rxBinding = ActivityRxJavaSimpleBinding.inflate(getLayoutInflater());
        setContentView(rxBinding.getRoot());

        RxJavaSimpleViewModel viewModel = new RxJavaSimpleViewModel();
        viewModel.uiState().observe(this, uiState -> {
           if (uiState != null) render(uiState);
        });

        rxBinding.btnServer.setOnClickListener(v -> viewModel.simpleRxExample());
    }

    @Override
    public void onLoad() {
        Toast.makeText(this, "Please wait a few seconds", Toast.LENGTH_SHORT).show();
        rxBinding.progressbarRx.setVisibility(View.VISIBLE);
        rxBinding.btnServer.setEnabled(false);
    }

    @Override
    public void onSuccess(@NonNull UiState.Success uiState) {
        rxBinding.progressbarRx.setVisibility(View.GONE);
        rxBinding.btnServer.setEnabled(true);
        rxBinding.tvResult.setText(uiState.getSuccessMessage());
    }

    @Override
    public void onError(@NonNull UiState.Error uiState) {
        Toast.makeText(this, uiState.getErrorMessage(), Toast.LENGTH_SHORT).show();
        rxBinding.progressbarRx.setVisibility(View.GONE);
        rxBinding.btnServer.setEnabled(true);
    }
}
