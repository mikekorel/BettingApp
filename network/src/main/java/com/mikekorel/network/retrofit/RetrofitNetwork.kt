package com.mikekorel.network.retrofit

import com.mikekorel.core.utils.Resource
import com.mikekorel.network.NetworkDataSource
import com.mikekorel.network.model.SportApiModel
import retrofit2.Response
import retrofit2.http.GET
import javax.inject.Inject
import javax.inject.Singleton

interface RetrofitNetworkApi {

    @GET("sports")
    suspend fun getSportsList(): Response<List<SportApiModel>>

}

@Singleton
class RetrofitNetwork @Inject constructor(
    private val networkApi: RetrofitNetworkApi
) : NetworkDataSource {

    override suspend fun getSportsList(): Resource<List<SportApiModel>> {
        val response =  networkApi.getSportsList()
        return if (response.isSuccessful) {
            Resource.Success(response.body())
        } else {
            Resource.Error(response.message())
        }
    }

}