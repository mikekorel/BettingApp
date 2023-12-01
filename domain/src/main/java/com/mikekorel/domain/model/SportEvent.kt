package com.mikekorel.domain.model

import com.mikekorel.network.model.SportEventApiModel

data class SportEvent (
    val id: String? = null,
    val sportId: String? = null,
    val name: String? = null,
    val startTime: Long? = null,
)

fun SportEventApiModel.toDomainModel() =
    SportEvent(
        id = id,
        sportId = sportId,
        name = name,
        startTime = startTime,
    )