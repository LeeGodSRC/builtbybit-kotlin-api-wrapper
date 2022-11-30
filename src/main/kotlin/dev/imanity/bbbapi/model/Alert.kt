package dev.imanity.bbbapi.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Alert(
    @SerialName("caused_member_id") val causedMemberId: Int,
    @SerialName("content_type") val contentType: String,
    @SerialName("content_id") val contentId: Int,
    @SerialName("alert_type") val alertType: String,
    @SerialName("alert_date") val alertDate: Long
)