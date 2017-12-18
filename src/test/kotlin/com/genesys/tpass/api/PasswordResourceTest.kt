package com.genesys.tpass.api

import com.genesys.tpass.api.dto.StatusCode
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author rzinalie
 */
class PasswordResourceTest {

    private val resource = PasswordResource()

    @Test
    fun create() {
        val response = resource.create("roman", 100)

        assertEquals(StatusCode.NOT_IMPLEMENTED, response.code)
    }
}