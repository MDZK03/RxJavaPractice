package com.example.rxjavapractice.view.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rxjavapractice.base.BaseFragment
import com.example.rxjavapractice.base.ListAdapter
import com.example.rxjavapractice.base.UiState
import com.example.rxjavapractice.data.books
import com.example.rxjavapractice.data.example3Description
import com.example.rxjavapractice.databinding.FragmentBookBinding
import com.example.rxjavapractice.viewmodel.BookViewModel

class BookFragment : BaseFragment<FragmentBookBinding>(
    FragmentBookBinding::inflate
){

    private var listAdapter = ListAdapter(books)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(requireActivity())[BookViewModel::class.java]
        viewModel.uiState().observe(requireActivity()) { uiState -> if(uiState != null) render(uiState) }
        viewModel.loadBookList()
        binding.bookList.apply {
            adapter = listAdapter
            hasFixedSize()
            layoutManager = LinearLayoutManager(requireActivity())
        }
    }

    override fun getToolbarTitle(): String = example3Description
    override fun onLoad() {
        Toast.makeText(requireActivity(),"Loading",Toast.LENGTH_SHORT).show()
    }

    override fun onSuccess(uiState: UiState.Success) {
        binding.loader.visibility = View.GONE
        binding.bookList.visibility = View.VISIBLE
        Toast.makeText(requireActivity(),uiState.successMessage,Toast.LENGTH_SHORT).show()
    }

    override fun onError(uiState: UiState.Error) {
        Toast.makeText(requireActivity(),uiState.errorMessage,Toast.LENGTH_SHORT).show()
    }
}