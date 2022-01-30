package com.faizzfanani.githubapp.utils

import com.faizzfanani.githubapp.data.source.local.entity.RepositoryEntity
import com.faizzfanani.githubapp.data.source.local.entity.RepositoryOwner
import com.faizzfanani.githubapp.data.source.local.entity.UserDetailEntity
import com.faizzfanani.githubapp.data.source.local.entity.UserEntity

object DataDummy {
    val userEntity = UserDetailEntity(
        id = 39150528,
        login = "faizzfanani",
        name = "Moh. Faiz Fanani",
        location = "South Jakarta",
        bio = "Mobile developer",
        nodeID = "MDQ6VXNlcjM5MTUwNTI4",
        avatarURL = "https://avatars.githubusercontent.com/u/39150528?v=4",
        url = "https://api.github.com/users/faizzfanani",
        publicRepos = 8,
        followers = 7,
        following = 10,
        type = "User"
    )
    val userList = listOf(
        UserEntity(id = 1, login = "mojombo", nodeID = "MDQ6VXNlcjE=", avatarURL = "https://avatars.githubusercontent.com/u/1?v=4", url = "https://api.github.com/users/mojombo",followerURL = "https://api.github.com/users/mojombo/followers", followingURL = "https://api.github.com/users/mojombo/following{/other_user}", subscriptionURL = "https://api.github.com/users/mojombo/subscriptions", organizationURL = "https://api.github.com/users/mojombo/orgs", reposURL = "https://api.github.com/users/mojombo/repos", eventsURL = "https://api.github.com/users/mojombo/events{/privacy}", type = "User"),
        UserEntity(id = 1, login = "mojombo", nodeID = "MDQ6VXNlcjE=", avatarURL = "https://avatars.githubusercontent.com/u/1?v=4", url = "https://api.github.com/users/mojombo",followerURL = "https://api.github.com/users/mojombo/followers", followingURL = "https://api.github.com/users/mojombo/following{/other_user}", subscriptionURL = "https://api.github.com/users/mojombo/subscriptions", organizationURL = "https://api.github.com/users/mojombo/orgs", reposURL = "https://api.github.com/users/mojombo/repos", eventsURL = "https://api.github.com/users/mojombo/events{/privacy}", type = "User"),
        UserEntity(id = 1, login = "mojombo", nodeID = "MDQ6VXNlcjE=", avatarURL = "https://avatars.githubusercontent.com/u/1?v=4", url = "https://api.github.com/users/mojombo",followerURL = "https://api.github.com/users/mojombo/followers", followingURL = "https://api.github.com/users/mojombo/following{/other_user}", subscriptionURL = "https://api.github.com/users/mojombo/subscriptions", organizationURL = "https://api.github.com/users/mojombo/orgs", reposURL = "https://api.github.com/users/mojombo/repos", eventsURL = "https://api.github.com/users/mojombo/events{/privacy}", type = "User")
    )
    val repos = listOf(
        RepositoryEntity(id = 4061, owner = RepositoryOwner(login = "pjhyett"), name = "auto_migrations", fullName = "pjhyett/auto_migrations", nodeID = "MDEwOlJlcG9zaXRvcnk0MDYx", description = "Rails plugin for automating migrations", updatedAt = "2021-04-17T04:46:31Z", starCount = 147, language = "Ruby"),
        RepositoryEntity(id = 4061, owner = RepositoryOwner(login = "pjhyett"), name = "auto_migrations", fullName = "pjhyett/auto_migrations", nodeID = "MDEwOlJlcG9zaXRvcnk0MDYx", description = "Rails plugin for automating migrations", updatedAt = "2021-04-17T04:46:31Z", starCount = 147, language = "Ruby"),
        RepositoryEntity(id = 4061, owner = RepositoryOwner(login = "pjhyett"), name = "auto_migrations", fullName = "pjhyett/auto_migrations", nodeID = "MDEwOlJlcG9zaXRvcnk0MDYx", description = "Rails plugin for automating migrations", updatedAt = "2021-04-17T04:46:31Z", starCount = 147, language = "Ruby"),
        RepositoryEntity(id = 4061, owner = RepositoryOwner(login = "pjhyett"), name = "auto_migrations", fullName = "pjhyett/auto_migrations", nodeID = "MDEwOlJlcG9zaXRvcnk0MDYx", description = "Rails plugin for automating migrations", updatedAt = "2021-04-17T04:46:31Z", starCount = 147, language = "Ruby"),
        RepositoryEntity(id = 4061, owner = RepositoryOwner(login = "pjhyett"), name = "auto_migrations", fullName = "pjhyett/auto_migrations", nodeID = "MDEwOlJlcG9zaXRvcnk0MDYx", description = "Rails plugin for automating migrations", updatedAt = "2021-04-17T04:46:31Z", starCount = 147, language = "Ruby")
    )
}