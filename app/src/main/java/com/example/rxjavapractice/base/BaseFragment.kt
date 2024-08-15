package com.example.rxjavapractice.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import java.lang.reflect.ParameterizedType
import androidx.viewbinding.ViewBinding
import androidx.fragment.app.createViewModelLazy
import com.example.rxjavapractice.R

@Suppress("UNCHECKED_CAST")
abstract class BaseFragment<B: ViewBinding, VM: ViewModel> (
    private val bindingFactory: (LayoutInflater) -> B,
    private val vmClass: Class<VM>
) : Fragment() {

    protected var binding: B? = null
    protected lateinit var viewModel: VM

    private val type = (javaClass.genericSuperclass as ParameterizedType)
    private val classVB = type.actualTypeArguments[0] as Class<B>

    private val inflateMethod = classVB.getMethod(
        "inflate",
        bindingFactory::class.java,
        ViewGroup::class.java,
        Boolean::class.java
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflateMethod.invoke(null, inflater, container, false) as B
        viewModel = createViewModelLazy(vmClass.kotlin, { viewModelStore }).value
        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
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