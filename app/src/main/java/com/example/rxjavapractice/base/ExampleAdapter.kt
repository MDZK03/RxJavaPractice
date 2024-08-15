package com.example.rxjavapractice.base

import com.example.rxjavapractice.databinding.ExampleItemBinding

class ExampleAdapter (
    private val exampleList : List<Example>,
    private val onExampleClick: (Example) -> Unit,
) : BaseAdapter<ExampleItemBinding, Example>(ExampleItemBinding::inflate, exampleList, onExampleClick) {

    override fun onBindViewHolder(holder: BaseViewHolder<ExampleItemBinding>, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.binding.textView.text = exampleList[position].description
        holder.binding.textView.setOnClickListener {
            onExampleClick(exampleList[position])
        }
    }
}