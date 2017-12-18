package com.genesys.tpass.api.exceptionmappers

import com.genesys.tpass.api.dto.ApiResponse
import com.genesys.tpass.api.dto.StatusCode
import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper

/**
 *
 * @author rzinalie
 */
class DefaultExceptionMapper : ExceptionMapper<Throwable> {
    override fun toResponse(exception: Throwable?): Response {

        return Response.ok()
                .entity(ApiResponse(
                        exception?.message ?: "unknown reason",
                        StatusCode.INTERNAL_SERVER_ERROR,
                        null
                ))
                .build()
    }
}