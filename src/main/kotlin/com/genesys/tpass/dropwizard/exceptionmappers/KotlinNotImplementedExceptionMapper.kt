package com.genesys.tpass.dropwizard.exceptionmappers

import com.genesys.tpass.common.models.ApiResponse
import com.genesys.tpass.common.models.StatusCode
import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper

class KotlinNotImplementedExceptionMapper : ExceptionMapper<NotImplementedError> {

    override fun toResponse(exception: NotImplementedError?): Response {

        return Response.ok()
                .entity(ApiResponse(
                        exception?.message ?: "unknown reason",
                        StatusCode.NOT_IMPLEMENTED,
                        null
                ))
                .build()
    }
}