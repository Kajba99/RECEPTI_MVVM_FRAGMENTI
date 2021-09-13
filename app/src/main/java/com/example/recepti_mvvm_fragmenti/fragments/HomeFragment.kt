package com.example.recepti_mvvm_fragmenti.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recepti_mvvm_fragmenti.R
import com.example.recepti_mvvm_fragmenti.adapter.RecipeAdapter
import com.example.recepti_mvvm_fragmenti.databinding.FragmentHomeBinding
import com.example.recepti_mvvm_fragmenti.viewmodel.RecipeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: RecipeViewModel by viewModels()
    private lateinit var recipeAdapter: RecipeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRv()
    }

    private fun setUpRv() {

        recipeAdapter = RecipeAdapter()

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            setHasFixedSize(true)
            adapter = recipeAdapter
        }

        viewModel.recipeResponse.observe(requireActivity(), { response ->
            recipeAdapter.recipe = response.articles
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}