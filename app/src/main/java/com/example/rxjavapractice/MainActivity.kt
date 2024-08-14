package com.example.rxjavapractice

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rxjavapractice.base.BaseActivity
import com.example.rxjavapractice.base.ExampleActivity
import com.example.rxjavapractice.base.ExampleCategory
import com.example.rxjavapractice.base.ExampleCategoryAdapter
import com.example.rxjavapractice.base.UiState
import com.example.rxjavapractice.base.exampleCategories
import com.example.rxjavapractice.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        hideBackButton()
        initRecyclerView()
    }

    private val onExampleCategoryClickListener: (ExampleCategory) -> Unit =
        { clickedExampleCategory ->
            val intent = ExampleActivity.newIntent(applicationContext, clickedExampleCategory)
            startActivity(intent)
        }

    private fun initRecyclerView() {
        binding.rvMain.apply {
            adapter =
                ExampleCategoryAdapter(
                    exampleCategories,
                    onExampleCategoryClickListener
                )
            hasFixedSize()
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(initItemDecoration())
        }
    }

    private fun initItemDecoration(): DividerItemDecoration {
        val itemDecorator =
            DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
        itemDecorator.setDrawable(
            ContextCompat.getDrawable(
                applicationContext,
                R.drawable.recyclerview_divider
            )!!
        )
        return itemDecorator
    }

    override fun getToolbarTitle() = "RxJava examples"
    override fun onLoad() {
        TODO("Not yet implemented")
    }

    override fun onSuccess(uiState: UiState.Success) {
        TODO("Not yet implemented")
    }

    override fun onError(uiState: UiState.Error) {
        TODO("Not yet implemented")
    }
}