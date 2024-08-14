package com.example.rxjavapractice.base

import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.rxjavapractice.R

abstract class ToolbarActivity : AppCompatActivity() {

    abstract fun getToolbarTitle(): String

    override fun onStart() {
        super.onStart()
        setToolbarTitle(getToolbarTitle())
        getBackButton().setOnClickListener {
            finish()
        }
    }

    private fun getBackButton(): ImageView = findViewById(R.id.btnBack)
    private fun getToolBar(): TextView = findViewById(R.id.tvToolbarTitle)

    fun hideBackButton() {
        getBackButton().visibility = View.GONE
    }

    private fun setToolbarTitle(toolbarTitle: String) {
        getToolBar().text = toolbarTitle
    }
}