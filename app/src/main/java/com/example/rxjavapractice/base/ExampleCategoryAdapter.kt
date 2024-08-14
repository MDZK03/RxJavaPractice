package com.example.rxjavapractice.base

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rxjavapractice.R

class ExampleCategoryAdapter(
    private val exampleCategories: List<ExampleCategory>,
    private val onExampleCategoryClick: (ExampleCategory) -> Unit
) : RecyclerView.Adapter<ExampleCategoryAdapter.ViewHolder>() {

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item, parent, false) as TextView
        return ViewHolder(
            textView
        )
    }

    override fun getItemCount() = exampleCategories.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = exampleCategories[position].categoryName
        holder.textView.setOnClickListener {
            onExampleCategoryClick(exampleCategories[position])
        }
    }
}