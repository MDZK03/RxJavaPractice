package com.example.rxjavapractice.viewmodel

import com.example.rxjavapractice.base.BaseViewModel
import com.example.rxjavapractice.base.ListAdapter
import com.example.rxjavapractice.base.UiState
import com.example.rxjavapractice.data.colorList
import com.example.rxjavapractice.data.colors
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ColorViewModel : BaseViewModel<UiState>() {
    private var disposable = CompositeDisposable()
    private var colorListObservable = Observable.just(colors)
    private var listAdapter = ListAdapter(colors)
    fun loadColorList() {
        uiState.value = UiState.Loading()
        for (i in colorList) {
            colors.add(i.colorName)
        }
        val subscribe : Disposable = colorListObservable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
            { colors -> listAdapter.setList(colors) },
            { err -> uiState.value = UiState.Error("$err")})
        disposable.add(subscribe)
        uiState.value = UiState.Success("Done")
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}