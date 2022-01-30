package com.faizzfanani.githubapp.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class UserResponse (
    val id : Int,
    val login : String,
    @SerializedName("node_id")
    val nodeID : String,
    @SerializedName("avatar_url")
    val avatarURL : String,
    val url : String,
    @SerializedName("followers_url")
    val followerURL : String,
    @SerializedName("following_url")
    val followingURL : String,
    @SerializedName("subscription_url")
    val subscriptionURL : String,
    @SerializedName("organizations_url")
    val organizationURL : String,
    @SerializedName("repos_url")
    val reposURL : String,
    @SerializedName("events_url")
    val eventsURL : String,
    val type : String)