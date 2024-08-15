package com.example.rxjavapractice.viewmodel

import android.os.SystemClock
import com.example.rxjavapractice.base.BaseViewModel
import com.example.rxjavapractice.base.UiState
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RxJavaSimpleViewModel: BaseViewModel<UiState>() {
    private var disposable = CompositeDisposable()
    private val serverDownloadObservable = Observable.create { emitter: ObservableEmitter<String?> ->
        SystemClock.sleep(5000)
        emitter.onNext("This example works fine.")
        emitter.onComplete()
    }

    fun runSimpleRxExample() {
        uiState.value = UiState.Loading()
        val subscribe = serverDownloadObservable
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .onErrorReturn { "Something went wrong." }
            .subscribe(
                { string: String? -> uiState.setValue(UiState.Success(string!!)) },
                { e: Throwable? -> uiState.setValue(UiState.Error("$e")) })
        disposable.add(subscribe)
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}
