package com.example.rxjavapractice.base

import android.os.Parcelable
import androidx.fragment.app.Fragment
import com.example.rxjavafragment.view.fragment.BookFragment
import com.example.rxjavafragment.view.fragment.CallableExampleFragment
import com.example.rxjavafragment.view.fragment.ColorFragment
import com.example.rxjavafragment.view.fragment.FlowableExampleFragment
import com.example.rxjavafragment.view.fragment.RxJavaSimpleFragment
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Example(
    val description: String,
    val targetFragment: @RawValue Fragment,
) : Parcelable

const val example1Description = "#1 RxJava simple example"
const val example2Description = "#2 Color list example"
const val example3Description = "#3 Book list example"
const val example4Description = "#4 Callable example"
const val example5Description = "$5 Flowable example"

val exampleList = listOf(
    Example (
        example1Description, RxJavaSimpleFragment()
    ),
    Example (
        example2Description, ColorFragment()
    ),
    Example (
        example3Description, BookFragment()
    ),
    Example (
        example4Description, CallableExampleFragment()
    ),
    Example (
        example5Description, FlowableExampleFragment()
    )
)