package com.faizzfanani.githubapp.ui.list

import androidx.lifecycle.ViewModel
import com.faizzfanani.githubapp.data.repository.Repository

class ListViewModel(private val repository: Repository) : ViewModel() {
    fun getUserList() = repository.getUserList()
}