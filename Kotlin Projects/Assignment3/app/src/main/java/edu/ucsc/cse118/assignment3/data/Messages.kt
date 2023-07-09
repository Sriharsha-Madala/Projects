package edu.ucsc.cse118.assignment3.data

import kotlinx.serialization.Serializable

@Serializable
data class Messages(
    val id: String,
    val poster: String,
    var date: String,
    val content: String
)
