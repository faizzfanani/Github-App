package com.faizzfanani.githubapp.ui.detail

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.faizzfanani.githubapp.data.source.local.entity.RepositoryEntity
import com.faizzfanani.githubapp.databinding.ItemReposBinding
import com.faizzfanani.githubapp.utils.Utils

class RepositoryAdapter : RecyclerView.Adapter<RepositoryAdapter.Holder>() {
    private val list = arrayListOf<RepositoryEntity>()
    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<RepositoryEntity>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemReposBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: Holder, position: Int) {
        if (list[position].name.isNullOrEmpty()) holder.binding.itemRepoName.text = "-"
        if (list[position].description.isNullOrEmpty()) holder.binding.itemRepoDesc.text = "-"
        if (list[position].language.isNullOrEmpty()) holder.binding.itemRepoLanguage.visibility = View.GONE
        holder.binding.itemRepoName.text = list[position].name
        holder.binding.itemRepoFullName.text = list[position].fullName
        holder.binding.itemRepoLanguage.text = list[position].language
        holder.binding.itemRepoDesc.text = list[position].description
        holder.binding.itemRepoRating.text = list[position].starCount.toString()
        holder.binding.itemRepoLastUpdate.text = "last update : "+list[position].updatedAt?.let { Utils.dateTimeFormatter(it) }
    }

    class Holder(val binding: ItemReposBinding) : RecyclerView.ViewHolder(binding.root)
}