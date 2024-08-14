package com.example.rxjavapractice.examples.example5

import com.example.rxjavapractice.base.BaseViewModel
import com.example.rxjavapractice.base.UiState
import io.reactivex.Flowable

class FlowableExampleViewModel: BaseViewModel<UiState>() {
    private val flowableExample = Flowable.just(1,2,3,4)

    fun doSomeWork() {
        flowableExample
            .reduce(100) {t1: Int, t2: Int -> t1+t2}
            .subscribe()
    }
}