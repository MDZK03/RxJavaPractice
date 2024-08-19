package com.example.rxjavapractice.viewmodel

import android.os.SystemClock
import com.example.rxjavapractice.base.BaseViewModel
import com.example.rxjavapractice.base.ListAdapter
import com.example.rxjavapractice.base.UiState
import com.example.rxjavapractice.data.bookList
import com.example.rxjavapractice.data.books
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Callable

class BookViewModel : BaseViewModel<UiState>() {
    private var disposable = CompositeDisposable()
    private var delayBook = Callable {
        SystemClock.sleep(5000)
        return@Callable books
    }
    private var bookListObservable = Observable.fromCallable(delayBook)
    private var listAdapter = ListAdapter(books)
    fun loadBookList() {
        uiState.value = UiState.Loading()
        for (i in bookList) {
            books.add(i.bookName)
        }
        val subscribe : Disposable = bookListObservable
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