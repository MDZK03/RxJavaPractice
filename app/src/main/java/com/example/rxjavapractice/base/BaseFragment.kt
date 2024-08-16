package com.example.rxjavapractice.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.example.rxjavapractice.R

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<B: ViewBinding, V: BaseViewModel<UiState>> (
    private val inflate: Inflate<B>,
    private val vmClass: Class<V>
) : Fragment() {

    private var _binding: B? = null
    protected val binding: B get() = _binding!!
    protected lateinit var viewModel: V

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        viewModel = ViewModelProvider(this)[vmClass]
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
}