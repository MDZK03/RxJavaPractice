package com.example.rxjavapractice.examples.example2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rxjavapractice.SimpleStringAdapter;
import com.example.rxjavapractice.base.BaseActivity;
import com.example.rxjavapractice.base.UiState;
import com.example.rxjavapractice.databinding.ActivityColorBinding;
import com.example.rxjavapractice.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class ColorActivity extends BaseActivity {
    RecyclerView colorListView;
    SimpleStringAdapter simpleStringAdapter;
    private Disposable disposable;

    @NonNull
    @Override
    public String getToolbarTitle() {
        return Constants.SECOND_EXAMPLE;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        configureLayout();
        createObservable();
    }

    private void configureLayout() {
        ActivityColorBinding colorBinding = ActivityColorBinding.inflate(getLayoutInflater());
        setContentView(colorBinding.getRoot());
        colorListView = colorBinding.colorList;
        colorListView.setLayoutManager(new LinearLayoutManager(this));
        simpleStringAdapter = new SimpleStringAdapter(this);
        colorListView.setAdapter(simpleStringAdapter);
    }
    private void createObservable() {
        Observable<List<String>> listObservable = Observable.just(getColorList());
        disposable = listObservable.subscribe(colors -> simpleStringAdapter.setStrings(colors));
    }

    private static List<String> getColorList() {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("red");
        colors.add("blue");
        colors.add("green");
        colors.add("yellow");
        return colors;
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(disposable != null && !disposable.isDisposed()) disposable.dispose();
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
