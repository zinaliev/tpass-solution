package com.genesys.tpass.api;

import com.genesys.tpass.api.dto.ApiResponseDto;
import com.genesys.tpass.api.dto.OperationsCountDto;
import com.genesys.tpass.api.dto.VerificationAttemptDto;
import com.genesys.tpass.conf.TPassConfiguration;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/statistics")
@Produces(MediaType.APPLICATION_JSON)
public class StatisticsResource {

    /**
     * Retrieve count of operations completed during service's up time
     * @return count of password creations, failed and passed verifications
     */
    @GET
    @Path("/operationsCount")
    public ApiResponseDto<OperationsCountDto> getOperationsCount(){
        return ApiResponseDto.notImplemented("/statistics/operationsCount");
    }

    /**
     * Retrieve info about last verifications' attempts
     * History entries must be listed in time descending order
     * (from the latest verification attempt to the very first one)
     * @param itemsCount number of verifications to display
     * @return info about last verification attempts
     * @implNote since 'depth' of history stored by service is limited with {@link TPassConfiguration#getHistorySize()},
     * so in case of requested {@code itemsCount} exceeds history size - return all available history entries
     */
    @GET
    @Path("/verificationsLog")
    public ApiResponseDto<VerificationAttemptDto[]> getVerificationsLog(@QueryParam("count") Integer itemsCount){
        return ApiResponseDto.notImplemented("/statistics/verificationsLog");
    }
}
