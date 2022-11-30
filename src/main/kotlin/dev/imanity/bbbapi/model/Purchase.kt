package dev.imanity.bbbapi.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Purchase(
    @SerialName("purchase_id") val purchaseId: Int,
    @SerialName("purchaser_id") val purchaserId: Int,
    @SerialName("license_id") val licenseId: Int,
    @SerialName("is_renewal") val isRenewal: Boolean,
    val status: String,
    val price: Double,
    val currency: String,
    @SerialName("purchase_date") val purchaseDate: Long,
    @SerialName("validation_date") val validationDate: Long
)