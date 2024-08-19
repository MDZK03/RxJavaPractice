package com.example.rxjavapractice.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rxjavapractice.databinding.ListItemBinding

class ListAdapter<T> (
    private val stringList: ArrayList<T>,
): RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    class ViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = stringList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.textDisplay.text = stringList[position].toString()
    }

    public fun setList(newList: List<T>) {
        stringList.clear()
        stringList.addAll(newList)
        notifyDataSetChanged()
    }
}