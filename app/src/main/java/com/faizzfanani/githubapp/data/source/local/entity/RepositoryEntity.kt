package com.faizzfanani.githubapp.data.source.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RepositoryEntity (
    @PrimaryKey
    val id : Int,
    @Embedded
    val owner : RepositoryOwner?,
    val name : String?,
    val fullName : String?,
    val nodeID : String?,
    val description : String?,
    val updatedAt : String?,
    val starCount : Int?,
    val language : String?)