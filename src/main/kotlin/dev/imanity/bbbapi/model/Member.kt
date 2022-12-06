package dev.imanity.bbbapi.model

import com.google.gson.annotations.SerializedName

data class Member(
    @SerializedName("member_id") val memberId: Int,
    val username: String,
    @SerializedName("join_date") val joinDate: Long = -1,
    @SerializedName("last_activity_date") val lastActivityDate: Long = -1,
    @SerializedName("banned") val isBanned: Boolean = false,
    @SerializedName("suspended") val isSuspended: Boolean = false,
    @SerializedName("restricted") val isRestricted: Boolean = false,
    @SerializedName("disabled") val isDisabled: Boolean = false,
    @SerializedName("premium") val isPremium: Boolean = false,
    @SerializedName("supreme") val isSupreme: Boolean = false,
    @SerializedName("ultimate") val isUltimate: Boolean = false,
    @SerializedName("discord_id") val discordId: Long = -1,
    @SerializedName("avatar_url") val avatarURL: String = "",
    @SerializedName("post_count") val postCount: Int = -1,
    @SerializedName("resource_count") val resourceCount: Int = -1,
    @SerializedName("purchase_count") val purchaseCount: Int = -1,
    @SerializedName("feedback_positive") val feedbackPositive: Int = -1,
    @SerializedName("feedback_neutral") val feedbackNeutral: Int = -1,
    @SerializedName("feedback_negative") val feedbackNegative: Int = -1
)