package dev.imanity.bbbapi.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Member(
    @SerialName("member_id") val memberId: Int,
    val username: String,
    @SerialName("join_date") val joinDate: Long = -1,
    @SerialName("last_activity_date") val lastActivityDate: Long = -1,
    @SerialName("banned") val isBanned: Boolean = false,
    @SerialName("suspended") val isSuspended: Boolean = false,
    @SerialName("restricted") val isRestricted: Boolean = false,
    @SerialName("disabled") val isDisabled: Boolean = false,
    @SerialName("premium") val isPremium: Boolean = false,
    @SerialName("supreme") val isSupreme: Boolean = false,
    @SerialName("ultimate") val isUltimate: Boolean = false,
    @SerialName("discord_id") val discordId: Long = -1,
    @SerialName("avatar_url") val avatarURL: String = "",
    @SerialName("post_count") val postCount: Int = -1,
    @SerialName("resource_count") val resourceCount: Int = -1,
    @SerialName("purchase_count") val purchaseCount: Int = -1,
    @SerialName("feedback_positive") val feedbackPositive: Int = -1,
    @SerialName("feedback_neutral") val feedbackNeutral: Int = -1,
    @SerialName("feedback_negative") val feedbackNegative: Int = -1
)