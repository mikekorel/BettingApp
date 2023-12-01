package com.mikekorel.data.repository

import com.mikekorel.core.utils.Resource
import com.mikekorel.network.NetworkDataSource
import com.mikekorel.network.model.SportApiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class SportsRepositoryImpl @Inject constructor(
    private val networkDataSource: NetworkDataSource,
) : SportsRepository {

    override fun getSports(): Flow<Resource<List<SportApiModel>>> {
        return flow {
            emit(
                try {
                    networkDataSource.getSportsList()
                } catch (t: Throwable) {
                    Resource.Error(t.message ?: t.localizedMessage)
                }
            )
        }
            .flowOn(Dispatchers.IO)
            .catch {
                emit(Resource.Error(it.message ?: it.localizedMessage))
            }
    }

}