package dev.imanity.bbbapi.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class License(
    @SerialName("license_id") val licenseId: Int,
    @SerialName("purchaser_id") val purchaserId: Int,
    @SerialName("is_validated") val isValidated: Boolean,
    @SerialName("is_active") val isActive: Boolean,
    @SerialName("start_date") val startDate: Long,
    @SerialName("end_date") val endDate: Long,
    @SerialName("previous_end_date") val previousEndDate: Long
)