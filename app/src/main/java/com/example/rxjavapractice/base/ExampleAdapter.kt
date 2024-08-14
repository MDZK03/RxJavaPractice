package com.example.rxjavapractice.base

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rxjavapractice.R

class ExampleAdapter (

    private val exampleCategory: ExampleCategory,
    private val onExampleClick: (Example) -> Unit

): RecyclerView.Adapter<ExampleAdapter.ViewHolder>() {

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item, parent, false) as TextView
        return ViewHolder(textView)
    }

    override fun getItemCount() = exampleCategory.examples.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = exampleCategory.examples[position].description
        holder.textView.setOnClickListener {
            onExampleClick(exampleCategory.examples[position])
        }
    }
}