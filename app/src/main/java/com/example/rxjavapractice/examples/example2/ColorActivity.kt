package com.example.rxjavapractice.examples.example2

import android.os.Bundle
import com.example.rxjavapractice.base.ToolbarActivity
import com.example.rxjavapractice.base.UiState
import com.example.rxjavapractice.base.example2Description

class ColorActivity : ToolbarActivity() {
    override fun getToolbarTitle(): String = example2Description

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}