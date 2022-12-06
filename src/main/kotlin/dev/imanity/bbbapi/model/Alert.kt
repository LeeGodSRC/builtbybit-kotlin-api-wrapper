package dev.imanity.bbbapi.model

import com.google.gson.annotations.SerializedName

data class Alert(
    @SerializedName("caused_member_id") val causedMemberId: Int,
    @SerializedName("content_type") val contentType: String,
    @SerializedName("content_id") val contentId: Int,
    @SerializedName("alert_type") val alertType: String,
    @SerializedName("alert_date") val alertDate: Long
)