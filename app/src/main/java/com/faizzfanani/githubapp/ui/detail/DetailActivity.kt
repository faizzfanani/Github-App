package com.faizzfanani.githubapp.ui.detail

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.faizzfanani.githubapp.data.source.local.entity.UserDetailEntity
import com.faizzfanani.githubapp.databinding.ActivityDetailBinding
import com.faizzfanani.githubapp.di.MyApplication
import com.faizzfanani.githubapp.ui.viewmodel.ViewModelFactory
import com.faizzfanani.githubapp.utils.Constant
import com.faizzfanani.githubapp.vo.Resource
import javax.inject.Inject

class DetailActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var binding: ActivityDetailBinding
    private var isSearch = false
    private val viewModel: DetailViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[DetailViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        MyApplication.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(Constant.username)
        isSearch = intent.getBooleanExtra(Constant.search, false)
        if (username != null) {
            loadUser(username)
            loadRepos(username)
        }
    }
    private fun loadUser(username: String){
        viewModel.getUserDetails(username).observe(this){resource ->
            when(resource){
                is Resource.Success -> {
                    if(isSearch && resource.data == null) userNotFound(username)
                    resource.data?.let {
                        setView(it)
                    }
                    hideShimmer()
                }
                is Resource.Loading -> {
                    showShimmer()
                }
                is Resource.Error -> {
                    hideShimmer()
                    if(isSearch && resource.data == null) userNotFound(username)
                    resource.data?.let {
                        setView(it)
                    }
                    Toast.makeText(this, resource.message.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    @SuppressLint("SetTextI18n")
    private fun loadRepos(username: String){
        val adapter = RepositoryAdapter()
        binding.rvRepos.layoutManager = LinearLayoutManager(applicationContext)
        binding.rvRepos.adapter = adapter
        viewModel.getRepos(username).observe(this){ resource ->
            when(resource){
                is Resource.Success -> {
                    resource.data?.let {
                        adapter.setList(it)
                    }
                    hideShimmer()
                }
                is Resource.Loading -> {
                    resource.data?.let {
                        adapter.setList(it)
                    }
                    if (resource.data.isNullOrEmpty()){
                        showShimmer()
                    }
                }
                is Resource.Error -> {
                    hideShimmer()
                    resource.data?.let {
                        adapter.setList(it)
                    }
                    if (resource.data.isNullOrEmpty())
                        binding.labelRepos.text = "Repository not found"
                    Toast.makeText(applicationContext, resource.message.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setView(data: UserDetailEntity){
        Glide.with(applicationContext).load(data.avatarURL).override(500,500).into(binding.detailAvatar)
        binding.detailUsername.text = "@"+data.login
        binding.containerDetails.detailFollower.text = data.followers.toString()
        binding.containerDetails.detailFollowing.text = data.following.toString()

        if (data.name.isNullOrEmpty())
            binding.detailName.text = "-"
        else if (!data.name.isNullOrEmpty())
            binding.detailName.text = data.name
        if (data.bio.isNullOrEmpty())
            binding.detailBio.text = "Bio : -"
        else if (!data.bio.isNullOrEmpty())
            binding.detailBio.text = data.bio
        if (data.location.isNullOrEmpty())
            binding.containerDetails.detailLocation.text = "-"
        else if (!data.location.isNullOrEmpty())
            binding.containerDetails.detailLocation.text = data.location

    }
    private fun showShimmer(){
        binding.shimmer.shimmerDetail.startShimmer()
        binding.shimmer.shimmerDetail.visibility = View.VISIBLE
        binding.labelRepos.visibility = View.GONE
        binding.layoutDetail.visibility = View.GONE
    }
    private fun hideShimmer(){
        binding.shimmer.shimmerDetail.stopShimmer()
        binding.labelRepos.visibility = View.VISIBLE
        binding.shimmer.shimmerDetail.visibility = View.GONE
        binding.layoutDetail.visibility = View.VISIBLE
    }
    @SuppressLint("SetTextI18n")
    private fun userNotFound(username: String){
        binding.userNotFound.labelUserNotFound.text = "Can't find user \"$username\""
        binding.userNotFound.root.visibility = View.VISIBLE
    }
}