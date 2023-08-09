package com.example.nambaone.ui.photo

import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.nambaone.data.model.RickAndMorty
import com.example.nambaone.databinding.FragmentPhotoBinding
import com.example.nambaone.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotoFragment : BaseFragment<FragmentPhotoBinding>(FragmentPhotoBinding::inflate) {

    private lateinit var viewModel: PhotoViewModel
    private var rickAndMorty = RickAndMorty()

    override fun setupView() {
        setupViewModel()
        initArguments()
        setTile(rickAndMorty.name)

        binding?.let { Glide.with(this).load(rickAndMorty.image).into(it.photo) }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this)[PhotoViewModel::class.java]
    }

    private fun initArguments() {
        rickAndMorty = arguments?.get(RICKANDMORTY) as RickAndMorty
    }

    companion object {
        const val RICKANDMORTY = "rickAndMorty"
    }
}