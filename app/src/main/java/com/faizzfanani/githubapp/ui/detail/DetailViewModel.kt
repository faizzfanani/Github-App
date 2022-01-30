package com.faizzfanani.githubapp.ui.detail

import androidx.lifecycle.ViewModel
import com.faizzfanani.githubapp.data.repository.Repository

class DetailViewModel(private val repository: Repository) : ViewModel() {
    fun getUserDetails(username: String) = repository.getUserDetails(username)
    fun getRepos(username: String) = repository.getRepos(username)
}