package com.example.rxjavapractice.examples.example1;

import android.os.SystemClock;
import com.example.rxjavapractice.base.BaseViewModel;
import com.example.rxjavapractice.base.UiState;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


class RxJavaSimpleViewModel extends BaseViewModel<UiState> {
    CompositeDisposable disposable = new CompositeDisposable();

    final Observable<String> serverDownloadObservable = Observable.create(emitter -> {
        SystemClock.sleep(5000);
        emitter.onNext("This example works fine.");
        emitter.onComplete();
    });

    public void simpleRxExample() {
        uiState.setValue(new UiState.Loading());

        Disposable subscribe = serverDownloadObservable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
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
