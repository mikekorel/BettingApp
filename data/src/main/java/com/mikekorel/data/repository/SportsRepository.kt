package com.mikekorel.data.repository

import com.mikekorel.core.utils.Resource
import com.mikekorel.network.model.SportApiModel
import kotlinx.coroutines.flow.Flow

interface SportsRepository {

    fun getSports(): Flow<Resource<List<SportApiModel>>>

}