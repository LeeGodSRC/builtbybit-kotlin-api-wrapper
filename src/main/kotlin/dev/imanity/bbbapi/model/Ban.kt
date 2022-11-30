package dev.imanity.bbbapi.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Ban(
    @SerialName("member_id") val memberId: Int,
    @SerialName("banned_by_id") val bannedById: Int,
    @SerialName("ban_date") val banDate: Long,
    val reason: String
    )