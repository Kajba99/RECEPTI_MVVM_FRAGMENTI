package com.example.recepti_mvvm_fragmenti.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.recepti_mvvm_fragmenti.R
import com.example.recepti_mvvm_fragmenti.databinding.FragmentDetailsBinding
import com.example.recepti_mvvm_fragmenti.model.Article


class DetailsFragment : Fragment(R.layout.fragment_details) {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private val args: DetailsFragmentArgs by navArgs()
    private lateinit var article: Article

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDetailsBinding.inflate(
            inflater, container, false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        article = args.article

        populateUI()


    }

    private fun populateUI () {

        binding.apply {
            tvTitleRecipeDetails.text = article.description
            ivDetails.load(article.urlToImage){
                crossfade(true)
                crossfade(1000)
            }

            btnOpenWebView.setOnClickListener { mView->
                val direction = DetailsFragmentDirections.actionDetailsFragmentToWebViewFragment(article)
                mView.findNavController().navigate(direction)

            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}