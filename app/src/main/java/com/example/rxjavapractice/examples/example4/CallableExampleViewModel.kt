package com.example.rxjavapractice.examples.example4

import android.os.SystemClock
import com.example.rxjavapractice.base.BaseViewModel
import com.example.rxjavapractice.base.UiState
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Callable

class CallableExampleViewModel : BaseViewModel<UiState>() {
    private var disposable = CompositeDisposable()
    private var callable = Callable {
        SystemClock.sleep(2000)
        "Hello"
    }

    fun runCallableExample() {
        uiState.value = UiState.Loading()
        val subscribe = Observable.fromCallable(callable)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
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
