package com.example.rxjavapractice.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseAdapter<B: ViewBinding, M>(
    private val bindingFactory: (LayoutInflater, ViewGroup?, Boolean) -> B,
    private val list: List<M>,
    private val itemClickListener: (M) -> Unit
) : RecyclerView.Adapter<BaseAdapter.BaseViewHolder<B>>() {

    class BaseViewHolder<B: ViewBinding>(binding : B) : RecyclerView.ViewHolder(binding.root) {
        var binding: B
        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<B> {
        val binding = bindingFactory.invoke(LayoutInflater.from(parent.context), parent, false)
        return BaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<B>, position: Int) {
        onBindViewHolder(holder,position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}