package com.example.nambaone.ui.main

import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.nambaone.R
import com.example.nambaone.data.model.RickAndMorty
import com.example.nambaone.databinding.FragmentHomeBinding
import com.example.nambaone.ui.base.BaseFragment
import com.example.nambaone.ui.main.adapter.RickAndMortyAdapter
import com.example.nambaone.ui.photo.PhotoFragment.Companion.RICKANDMORTY
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate), RickAndMortyAdapter.Listener {

    private var viewModel: HomeViewModel? = null
    private var adapter = RickAndMortyAdapter()

    override fun setupView() {
        if (viewModel == null) {
            setupViewModel()
            setupRecycle()

            binding?.refreshLayout?.setOnRefreshListener {
                viewModel?.getData()
            }
        }
    }

    private fun setupViewModel(){
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        viewModel?.rickAndMortyData?.observe(this){
            if (!it.isNullOrEmpty()){
                adapter.setData(it)
            }
        }

        viewModel?.loader?.observe(this){
            binding?.progress?.isVisible = it
            binding?.refreshLayout?.isRefreshing = it
        }
        viewModel?.errorMessageData?.observe(this){
            Toast.makeText(requireContext(), it ?: getString(R.string.error_messsage), Toast.LENGTH_SHORT).show()
        }
        viewModel?.getData()
    }

    private fun setupRecycle(){
        binding?.rickMortyRecycler?.adapter = adapter
        adapter.setListener(this)
    }

    override fun onItemClick(rickAndMorty: RickAndMorty) {
        findNavController().navigate(R.id.photoFragment, bundleOf(RICKANDMORTY to rickAndMorty))
    }
}