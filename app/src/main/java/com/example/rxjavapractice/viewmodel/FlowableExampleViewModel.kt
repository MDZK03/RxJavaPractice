package com.example.rxjavapractice.viewmodel

import com.example.rxjavapractice.base.BaseViewModel
import com.example.rxjavapractice.base.UiState
import io.reactivex.Flowable
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import timber.log.Timber

class FlowableExampleViewModel: BaseViewModel<UiState>() {
    private val flowableExample = Flowable.just(1,2,3,4)
    private var getObserver = object: SingleObserver<Int> {
        override fun onSubscribe(d: Disposable) {
            Timber.d("onSubscribe: $d")
        }

        override fun onError(e: Throwable) {
            Timber.e("onError: $e")
            uiState.value = UiState.Error("$e")
        }

        override fun onSuccess(t: Int) {
            Timber.e("onSuccess: $t")
            uiState.value = UiState.Success("$t")
        }
    }

    fun doSomeWork() {
        flowableExample
            .reduce(100) {t1: Int, t2: Int -> t1+t2}
            .subscribe(getObserver)
    }
}