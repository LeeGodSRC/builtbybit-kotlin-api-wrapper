package dev.imanity.bbbapi.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Version(
    @SerialName("version_id") val versionId: Int,
    @SerialName("update_id") val updateId: Int? = null,
    val name: String,
    @SerialName("release_date") val releaseDate: Long,
    @SerialName("download_count") val downloadCount: Int
    )