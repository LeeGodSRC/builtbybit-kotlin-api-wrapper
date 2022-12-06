package dev.imanity.bbbapi.model

import com.google.gson.annotations.SerializedName

data class License(
    @SerializedName("license_id") val licenseId: Int,
    @SerializedName("purchaser_id") val purchaserId: Int,
    @SerializedName("is_validated") val isValidated: Boolean,
    @SerializedName("active") val isActive: Boolean,
    @SerializedName("permanent") val isPermanent: Boolean,
    @SerializedName("start_date") val startDate: Long,
    @SerializedName("end_date") val endDate: Long,
    @SerializedName("previous_end_date") val previousEndDate: Long
)