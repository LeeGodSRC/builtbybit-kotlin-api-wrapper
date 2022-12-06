package dev.imanity.bbbapi.model

import com.google.gson.annotations.SerializedName

data class Version(
    @SerializedName("version_id") val versionId: Int,
    @SerializedName("update_id") val updateId: Int? = null,
    val name: String,
    @SerializedName("release_date") val releaseDate: Long,
    @SerializedName("download_count") val downloadCount: Int
    )