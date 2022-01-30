package com.faizzfanani.githubapp.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserDetailEntity (
    @PrimaryKey
    val id : Int,
    val login : String?,
    val name : String?,
    val location : String?,
    val bio : String?,
    val nodeID : String?,
    val avatarURL : String?,
    val url : String?,
    val publicRepos: Int?,
    val followers: Int?,
    val following: Int?,
    val type : String?)