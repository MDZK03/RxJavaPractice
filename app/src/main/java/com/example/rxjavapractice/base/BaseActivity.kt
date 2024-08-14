package com.example.rxjavapractice.base

import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.rxjavapractice.R

abstract class BaseActivity : AppCompatActivity() {

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

    fun render(uiState: UiState) {
        when (uiState) {
            is UiState.Loading -> {
                onLoad()
            }
            is UiState.Success -> {
                onSuccess(uiState)
            }
            is UiState.Error -> {
                onError(uiState)
            }
        }
    }
    abstract fun onLoad()
    abstract fun onSuccess(uiState: UiState.Success)
    abstract fun onError(uiState: UiState.Error)
}