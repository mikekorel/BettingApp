package com.mikekorel.domain.usecase

import com.mikekorel.core.utils.Resource
import com.mikekorel.data.repository.SportsRepository
import com.mikekorel.domain.model.Sport
import com.mikekorel.domain.model.toDomainModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetSportsListUseCase @Inject constructor(
    private val sportsRepository: SportsRepository
) {

    operator fun invoke() : Flow<Resource<List<Sport>>> {
        return sportsRepository.getSports().map { resource ->
            if (resource is Resource.Success) {
                Resource.Success(resource.data?.map { it.toDomainModel() })
            } else {
                Resource.Error(resource.message ?: "")
            }
        }
    }

}