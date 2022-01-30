package com.faizzfanani.githubapp.ui.list

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.faizzfanani.githubapp.data.source.local.entity.UserEntity
import com.faizzfanani.githubapp.databinding.ItemUserBinding
import com.faizzfanani.githubapp.ui.detail.DetailActivity
import com.faizzfanani.githubapp.utils.Constant.Companion.username

class UserAdapter : RecyclerView.Adapter<UserAdapter.Holder>() {
    private val list = arrayListOf<UserEntity>()
    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<UserEntity>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Holder, position: Int) {

        Glide.with(holder.itemView.context).load(list[position].avatarURL).override(500,500).into(holder.binding.itemAvatar)
        holder.binding.itemUsername.text = list[position].login

        //item click listener
        holder.binding.root.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra(username, list[position].login)
            holder.itemView.context.startActivity(intent)
        }
    }

    class Holder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)
}