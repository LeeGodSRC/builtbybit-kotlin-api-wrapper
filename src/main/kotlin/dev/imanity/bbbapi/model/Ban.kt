package dev.imanity.bbbapi.model

import com.google.gson.annotations.SerializedName

data class Ban(
    @SerializedName("member_id") val memberId: Int,
    @SerializedName("banned_by_id") val bannedById: Int,
    @SerializedName("ban_date") val banDate: Long,
    val reason: String
    )