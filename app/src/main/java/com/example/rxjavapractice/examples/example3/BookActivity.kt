package com.example.rxjavapractice.examples.example3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rxjavapractice.R
import com.example.rxjavapractice.base.ToolbarActivity
import com.example.rxjavapractice.base.example3Description

class BookActivity : ToolbarActivity() {
    override fun getToolbarTitle(): String = example3Description
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}