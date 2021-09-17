package com.test.moviedb.presentatiion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.test.moviedb.R
import com.test.moviedb.core.domain.Response
import com.test.moviedb.databinding.FragmentDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import android.os.Build

import android.annotation.TargetApi

import android.webkit.PermissionRequest

import android.webkit.WebChromeClient





class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private var movieId:Int = 0
    private var isMovie:Boolean = true
    private val viewModel by viewModel<DetailViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater,container,false).apply {
            webView.settings.javaScriptEnabled = true


        }
        viewModel.loadDetail(movieId, isMovie)
        viewModel.detail.observe(viewLifecycleOwner){
            when (it) {
                is Response.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Response.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.movieName.text = it.data.name
                    binding.webView.visibility = View.VISIBLE
                    binding.webView.loadUrl("https://www.youtube.com/embed/${it.data.key}")
                }
                is Response.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), "We couldn't load the data", Toast.LENGTH_LONG).show()
                }
                else -> {
                    binding.progressBar.visibility = View.GONE
                }
            }
        }

        return binding.root

    }

    companion object{
        fun newInstance(movieId:Int, isMovie:Boolean) = DetailFragment().apply {
            this.movieId = movieId
            this.isMovie = isMovie
        }
    }

}