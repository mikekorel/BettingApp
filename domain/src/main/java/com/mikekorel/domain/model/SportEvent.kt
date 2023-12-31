package com.mikekorel.domain.model

import com.mikekorel.network.model.SportEventApiModel

data class SportEvent (
    val id: String? = null,
    val sportId: String? = null,
    val firstTeamName: String? = null,
    val secondTeamName: String? = null,
    val startTime: Long? = null,
)

fun SportEventApiModel.toDomainModel() =
    SportEvent(
        id = id,
        sportId = sportId,
        firstTeamName = name?.split(" - ")?.getOrNull(0)?.trim(),
        secondTeamName = name?.split(" - ")?.getOrNull(1)?.trim(),
        startTime = (startTime ?: 0) + 6_000_000L,  // mock workaround to have meaningful dates
    )