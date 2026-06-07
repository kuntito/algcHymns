package com.example.algchymns.data.remote

import com.example.algchymns.data.remote.helpers.ApiCallInfo
import com.example.algchymns.data.remote.helpers.safeApiCall
import com.example.algchymns.data.remote.response_models.CheckForUpdatesResponse
import com.example.algchymns.data.remote.response_models.GetAllHymnsResponse
import retrofit2.http.GET

interface AlgcApiService {
    @GET("api/algc/allHymns")
    suspend fun getAllHymns(): GetAllHymnsResponse

    @GET("api/algc/checkForUpdates")
    suspend fun checkForUpdates(): CheckForUpdatesResponse
}

/**
 * a wrapper 'round the algc api client.
 *
 * ensures all API calls are safe
 * i.e. any errors they throw are caught and logged.
 * they never reach the caller.
 *
 * the caller gets a falsy response.
 */
class AlgcApiDataSource(
    private val api: AlgcApiService
) {
    /**
     * fetch all hymns from API.
     *
     * returns `null` if something goes wrong.
     */
    suspend fun safeFetchAllHymns() = safeApiCall(
        ApiCallInfo(
            "`getAllHymns` returns all hymns with their verses.",
            fn = {
                api.getAllHymns()
            }
        )
    )

    suspend fun safeCheckForUpdates() = safeApiCall(
        ApiCallInfo(
            fnDesc = "fn checks for updates",
            fn = {
                api.checkForUpdates()
            }
        )
    )
}