package com.mikekorel.domain.model

import com.mikekorel.network.model.SportApiModel


data class Sport(
    val id: String? = null,
    val name: String?,
    val events: List<SportEvent>? = null,
)

fun SportApiModel.toDomainModel() =
    Sport(
        id = id,
        name = name,
        events = events?.map { it.toDomainModel() },
    )