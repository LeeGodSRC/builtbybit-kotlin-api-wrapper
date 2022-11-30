package dev.imanity.bbbapi.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Member(
    @SerialName("member_id") val memberId: Int,
    val username: String,
    @SerialName("join_date") val joinDate: Long,
    @SerialName("last_activity_date") val lastActivityDate: Long,
    @SerialName("is_banned") val isBanned: Boolean,
    @SerialName("is_suspended") val isSuspended: Boolean,
    @SerialName("is_restricted") val isRestricted: Boolean,
    @SerialName("is_disabled") val isDisabled: Boolean,
    @SerialName("is_premium") val isPremium: Boolean,
    @SerialName("is_supreme") val isSupreme: Boolean,
    @SerialName("is_ultimate") val isUltimate: Boolean,
    @SerialName("discord_id") val discordId: Long,
    @SerialName("avatar_url") val avatarURL: String,
    @SerialName("post_count") val postCount: Int,
    @SerialName("resource_count") val resourceCount: Int,
    @SerialName("purchase_count") val purchaseCount: Int,
    @SerialName("feedback_positive") val feedbackPositive: Int,
    @SerialName("feedback_neutral") val feedbackNeutral: Int,
    @SerialName("feedback_negative") val feedbackNegative: Int
)