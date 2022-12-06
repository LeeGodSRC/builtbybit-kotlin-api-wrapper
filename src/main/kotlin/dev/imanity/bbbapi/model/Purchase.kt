package dev.imanity.bbbapi.model

import com.google.gson.annotations.SerializedName

data class Purchase(
    @SerializedName("purchase_id") val purchaseId: Int,
    @SerializedName("purchaser_id") val purchaserId: Int,
    @SerializedName("license_id") val licenseId: Int,
    @SerializedName("is_renewal") val isRenewal: Boolean,
    val status: String,
    val price: Double,
    val currency: String,
    @SerializedName("purchase_date") val purchaseDate: Long,
    @SerializedName("validation_date") val validationDate: Long
)