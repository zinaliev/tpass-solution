package com.genesys.tpass.api

import com.genesys.tpass.api.dto.ApiResponse
import com.genesys.tpass.conf.TPassConfig
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType

/**
 *
 * @author rzinalie
 */
@Path("/statistics")
@Produces(MediaType.APPLICATION_JSON)
class StatisticsResource {

    /**
     * Retrieve count of operations completed during service's up time
     * @return count of password creations, failed and passed verifications
     */
    @GET
    @Path("/operationsCount")
    fun getOperationsCount(): ApiResponse<Any> {
        return ApiResponse.notImplemented("/statistics/operationsCount")
    }

    /**
     * Retrieve info about last verifications' attempts
     * History entries must be listed in time descending order
     * (from the latest verification attempt to the very first one)
     * @param itemsCount number of verifications to display
     * @return info about last verification attempts
     * @implNote since 'depth' of history stored by service is limited with [TPassConfig.historySize],
     * so in case of requested `itemsCount` exceeds history size - return all available history entries
     */
    @GET
    @Path("/verificationsLog")
    fun getVerificationsLog(@QueryParam("count") itemsCount: Int?): ApiResponse<Any> {
        return ApiResponse.notImplemented("/statistics/verificationsLog")
    }
}