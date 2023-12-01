package com.mikekorel.network.model

import com.google.gson.annotations.SerializedName

data class SportApiModel(
    @SerializedName("i") val id: String? = null,
    @SerializedName("d") val name: String?,
    @SerializedName("e") val events: List<SportEventApiModel>? = null,
)
