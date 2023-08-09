package com.example.nambaone.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.example.nambaone.R

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VB : ViewBinding>(private val inflate: Inflate<VB>) : Fragment() {

    var toolbarBackButton: ImageView? = null
    var toolbarTitle: TextView? = null

    var binding: VB? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding == null) {
            binding = inflate.invoke(inflater, container, false)
            setupToolbar()
            setupView()
        }


        return binding!!.root
    }

    inline fun <reified T : ViewModel> getViewModel(): T {
        return ViewModelProvider(this)[T::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    protected fun setTile(title: String?) {
        toolbarTitle?.text = title
    }


    private fun setupToolbar() {
        try {
            val view: View? = binding?.root
            toolbarBackButton = view?.findViewById(R.id.toolbar_back_button)
            toolbarTitle = view?.findViewById(R.id.toolbar_title)

            toolbarBackButton?.setOnClickListener { findNavController().popBackStack() }
        } catch (e: Exception) {
            e.stackTrace
        }
    }

    protected abstract fun setupView()

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}