package com.example.rxjavapractice.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.rxjavapractice.R

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<B: ViewBinding> (
    private val inflate: Inflate<B>,
) : Fragment() {

    private var _binding: B? = null
    protected val binding: B get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    abstract fun getToolbarTitle(): String

    override fun onStart() {
        super.onStart()
        setToolbarTitle(getToolbarTitle())
        getBackButton().setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }
    }
    private fun getBackButton(): ImageView = requireView().findViewById(R.id.btnBack)
    private fun getToolBar(): TextView = requireView().findViewById(R.id.tvToolbarTitle)

    fun hideBackButton() {
        getBackButton().visibility = View.GONE
    }

    private fun setToolbarTitle(toolbarTitle: String) {
        getToolBar().text = toolbarTitle
    }

    fun render(uiState: UiState) {
        when (uiState) {
            is UiState.Loading -> {
                onLoad()
            }
            is UiState.Success -> {
                onSuccess(uiState)
            }
            is UiState.Error -> {
                onError(uiState)
            }
        }
    }
    abstract fun onLoad()
    abstract fun onSuccess(uiState: UiState.Success)
    abstract fun onError(uiState: UiState.Error)

}