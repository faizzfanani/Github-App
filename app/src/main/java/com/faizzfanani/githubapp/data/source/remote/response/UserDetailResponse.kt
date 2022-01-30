package com.faizzfanani.githubapp.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class UserDetailResponse (
    val id : Int,
    val login : String,
    val name : String,
    val location : String,
    val bio : String,
    @SerializedName("node_id")
    val nodeID : String,
    @SerializedName("avatar_url")
    val avatarURL : String,
    val url : String,
    @SerializedName("public_repos")
    val publicRepos: Int,
    val followers: Int,
    val following: Int,
    val type : String)