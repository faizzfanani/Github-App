package com.faizzfanani.githubapp.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class RepositoryResponse (
    val id : Int,
    val owner: RepositoryOwnerResponse,
    val name : String,
    @SerializedName("full_name")
    val fullName : String,
    @SerializedName("node_id")
    val nodeID : String,
    val description : String,
    @SerializedName("updated_at")
    val updatedAt : String,
    @SerializedName("stargazers_count")
    val starCount : Int,
    val language : String)