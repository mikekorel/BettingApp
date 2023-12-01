package com.mikekorel.network

import com.mikekorel.core.utils.Resource
import com.mikekorel.network.model.SportApiModel

interface NetworkDataSource {

    suspend fun getSportsList(): Resource<List<SportApiModel>>

}