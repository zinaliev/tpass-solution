package com.genesys.tpass.dropwizard.resources

import com.genesys.tpass.common.TPassService
import com.genesys.tpass.common.models.ApiResponse
import com.genesys.tpass.config.TPassConfig
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

    private val service = TPassService.instance

    /**
     * Retrieve count of operations completed during service's up time
     * @return count of password creations, failed and passed verifications
     */
    @GET
    @Path("/operationsCount")
    fun getOperationsCount(): ApiResponse<Any> {
        return service.getOperationsCount()
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
        return service.getVerificationsLog(itemsCount)
    }
}