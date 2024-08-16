package com.example.rxjavapractice.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rxjavapractice.R
import com.example.rxjavapractice.base.BaseFragment
import com.example.rxjavapractice.base.UiState
import com.example.rxjavapractice.base.example2Description
import com.example.rxjavapractice.databinding.FragmentColorBinding

class ColorFragment : BaseFragment<FragmentColorBinding>(
    FragmentColorBinding::inflate
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color, container, false)
    }

    override fun getToolbarTitle(): String = example2Description
    override fun onLoad() {
        TODO("Not yet implemented")
    }

    override fun onSuccess(uiState: UiState.Success) {
        TODO("Not yet implemented")
    }

    override fun onError(uiState: UiState.Error) {
        TODO("Not yet implemented")
    }

    companion object {
    }
}