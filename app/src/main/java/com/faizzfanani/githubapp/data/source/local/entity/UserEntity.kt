package com.faizzfanani.githubapp.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity (
    @PrimaryKey
    val id : Int,
    val login : String?,
    val nodeID : String?,
    val avatarURL : String?,
    val url : String?,
    val followerURL : String?,
    val followingURL : String?,
    val subscriptionURL : String?,
    val organizationURL : String?,
    val reposURL : String?,
    val eventsURL : String?,
    val type : String?
    )