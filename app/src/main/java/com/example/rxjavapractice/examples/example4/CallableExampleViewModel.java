package com.example.rxjavapractice.examples.example4;

import android.os.SystemClock;
import com.example.rxjavapractice.base.BaseViewModel;
import com.example.rxjavapractice.base.UiState;
import java.util.concurrent.Callable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CallableExampleViewModel extends BaseViewModel<UiState> {
    CompositeDisposable disposable = new CompositeDisposable();
    Callable<String> callable = () -> {
        SystemClock.sleep(2000);
        return "Hello";
    };
    public void callableExample() {
        uiState.setValue(new UiState.Loading());
        Disposable subscribe = Observable.fromCallable(callable)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        string -> uiState.setValue(new UiState.Success(string)),
                        err -> uiState.setValue(new UiState.Error("Something went wrong.")));
        disposable.add(subscribe);
    }
    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.dispose();
    }
}
