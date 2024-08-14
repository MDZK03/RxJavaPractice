package com.example.rxjavapractice.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rxjavapractice.R
import com.example.rxjavapractice.databinding.ActivityExampleBinding

class ExampleActivity : ToolbarActivity() {
    private val exampleCategory by lazy {
        intent.getParcelableExtra<ExampleCategory>(
            EXTRA_EXAMPLE_CATEGORY
        )!!
    }

    private lateinit var binding: ActivityExampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
    }

    private val onExampleClickListener: (Example) -> Unit = { clickedExample ->
        startActivity(Intent(applicationContext, clickedExample.targetActivity))
    }

    private fun initRecyclerView() {
        binding.recyclerView.apply {
            adapter =
                ExampleAdapter(
                    exampleCategory,
                    onExampleClickListener
                )
            hasFixedSize()
            layoutManager = LinearLayoutManager(this@ExampleActivity)
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

    override fun getToolbarTitle() = exampleCategory.categoryName
    companion object {

        private const val EXTRA_EXAMPLE_CATEGORY = "EXTRA_EXAMPLE_CATEGORIES"

        fun newIntent(context: Context, exampleCategory: ExampleCategory) =
            Intent(context, ExampleActivity::class.java).apply {
                putExtra(EXTRA_EXAMPLE_CATEGORY, exampleCategory)
            }
    }
}