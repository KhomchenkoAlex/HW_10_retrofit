package com.example.android.hw10.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
data class User(
    @JsonProperty("avatar_url")
    val avatarUrl: String?,
    @JsonProperty("name")
    val name: String?,
    @JsonProperty("location")
    val location: String?,
    @JsonProperty("public_repos")
    val publicRepos: Int?,
    @JsonProperty("public_gists")
    val publicGists: Int?,
    @JsonProperty("email")
    val email: String?,
    @JsonProperty("followers")
    val followers: Int?,
    @JsonProperty("following")
    val following: Int?
): Serializable