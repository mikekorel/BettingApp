package com.mikekorel.network.model

import com.google.gson.annotations.SerializedName

data class SportEventApiModel(
    @SerializedName("i") val id: String? = null,
    @SerializedName("si") val sportId: String? = null,
    @SerializedName("d") val name: String? = null,
    @SerializedName("tt") val startTime: Long? = null,
)
