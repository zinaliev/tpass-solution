package com.genesys.tpass.dropwizard.exceptionmappers

import com.genesys.tpass.common.models.ApiResponse
import com.genesys.tpass.common.models.StatusCode
import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper

/**
 *
 * @author rzinalie
 */
class KotlinIllegalArgumentExceptionMapper : ExceptionMapper<IllegalArgumentException> {

    override fun toResponse(exception: IllegalArgumentException?): Response {
        return Response.ok()
                .entity(ApiResponse(
                        exception?.message ?: "unknown reason",
                        StatusCode.BAD_REQUEST,
                        null
                ))
                .build()
    }
}