package com.example.rxjavapractice.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rxjavapractice.databinding.ExampleItemBinding

class ExampleAdapter (
    private val exampleList: List<Example>,
    private val onExampleClick: (Example) -> Unit
): RecyclerView.Adapter<ExampleAdapter.ViewHolder>() {
    class ViewHolder(val binding: ExampleItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ExampleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = exampleList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.textView.text = exampleList[position].description
        holder.binding.textView.setOnClickListener {
            onExampleClick(exampleList[position])
        }
    }
}