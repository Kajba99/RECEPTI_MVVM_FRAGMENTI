package com.example.recepti_mvvm_fragmenti.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.recepti_mvvm_fragmenti.databinding.FragmentHomeBinding
import com.example.recepti_mvvm_fragmenti.databinding.RecipeLayoutAdapterBinding
import com.example.recepti_mvvm_fragmenti.fragments.HomeFragmentDirections
import com.example.recepti_mvvm_fragmenti.model.Article

class RecipeAdapter: RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {


    inner class RecipeViewHolder(val binding: RecipeLayoutAdapterBinding):
        RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var recipe: List<Article>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(
            RecipeLayoutAdapterBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
       val current = recipe[position]
        holder.binding.apply {
            tvTitleRecipe.text = current.title
            imageView.load(current.urlToImage){
                crossfade(true)
                crossfade(1000)
            }
        }

        holder.itemView.setOnClickListener {mView ->
            val direction = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(current)
            mView.findNavController().navigate(direction)
        }
    }

    override fun getItemCount() = recipe.size

}