package com.example.rxjavapractice.base

import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import com.example.rxjavapractice.examples.example1.RxJavaSimpleActivity
import com.example.rxjavapractice.examples.example3.BookActivity
import com.example.rxjavapractice.examples.example2.ColorActivity
import com.example.rxjavapractice.examples.example4.CallableExampleActivity
import com.example.rxjavapractice.examples.example5.FlowableExampleActivity
import kotlinx.parcelize.Parcelize

@Parcelize
data class Example(
    val description: String,
    val targetActivity: Class<out AppCompatActivity>
) : Parcelable

@Parcelize
data class ExampleCategory(val categoryName: String, val examples: List<Example>) : Parcelable

const val example1Description = "#1 RxJava simple example"
const val example2Description = "#2 Color list example"
const val example3Description = "#3 Book list example"
const val example4Description = "#4 Callable example"
const val example5Description = "$5 Flowable example"

val simpleExamples = ExampleCategory ("Simple Example List",
    listOf(
        Example(
            example1Description, RxJavaSimpleActivity::class.java
        ),
        Example(
            example2Description, ColorActivity::class.java
        ),
        Example(
            example3Description, BookActivity::class.java
        ),
    )
)

val specificExamples = ExampleCategory ("Specific Example List",
    listOf(
        Example(
            example4Description, CallableExampleActivity::class.java
        ),
        Example(
            example5Description, FlowableExampleActivity::class.java
        ),
    )
)

val exampleCategories = listOf(simpleExamples, specificExamples)

