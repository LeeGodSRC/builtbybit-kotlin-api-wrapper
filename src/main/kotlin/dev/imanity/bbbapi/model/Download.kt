package dev.imanity.bbbapi.model

import com.google.gson.annotations.SerializedName

data class Download(
    @SerializedName("resource_id") val resourceId: Int,
    @SerializedName("version_id") val versionId: Int,
    @SerializedName("downloader_id") val downloaderId: Int,
    @SerializedName("download_date") val downloadDate: Long
    )