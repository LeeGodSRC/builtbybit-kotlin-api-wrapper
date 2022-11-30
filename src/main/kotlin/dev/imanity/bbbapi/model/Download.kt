package dev.imanity.bbbapi.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Download(
    @SerialName("resource_id") val resourceId: Int,
    @SerialName("version_id") val versionId: Int,
    @SerialName("downloader_id") val downloaderId: Int,
    @SerialName("download_date") val downloadDate: Long
    )