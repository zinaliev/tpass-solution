package com.genesys.tpass

import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.genesys.tpass.common.models.ApiResponse
import com.genesys.tpass.common.models.StatusCode
import com.genesys.tpass.dropwizard.TPassApplication
import com.google.common.io.Resources
import com.mashape.unirest.http.ObjectMapper
import com.mashape.unirest.http.Unirest
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test
import kotlin.test.assertEquals
import com.fasterxml.jackson.databind.ObjectMapper as JacksonObjectMapper

/**
 * @author rzinalie
 */
@SuppressWarnings("unchecked")
class TPassApplicationIT {
    companion object {

        private const val APP_MODE = "server"
        private val jacksonObjectMapper = JacksonObjectMapper()

        @BeforeClass
        @JvmStatic fun setUpClass(){
            setupServer()
            setupClient()
        }

        @AfterClass
        @JvmStatic fun tearDownClass(){
            Unirest.shutdown()
        }

        private fun setupServer() {
            val applicationArgs: Array<String> = arrayOf(
                    APP_MODE,
                    Resources.getResource("tpass-test.yml").path
            )

            TPassApplication().run(*applicationArgs)
        }

        private fun setupClient() {
            jacksonObjectMapper.registerModule(KotlinModule())

            Unirest.setObjectMapper(object: ObjectMapper{
                override fun writeValue(value: Any?): String {
                    return jacksonObjectMapper.writeValueAsString(value)
                }

                override fun <T : Any?> readValue(value: String?, valueType: Class<T>?): T {
                    return jacksonObjectMapper.readValue(value, valueType)
                }

            })
        }
    }

    @Test
    fun testPasswordCreateResponseCodeIsNotImplemented() {
        val response: ApiResponse<*> = Unirest.get("http://localhost:8080/password/create")
                .queryString("user", "John")
                .queryString("timeout", 10)
                .asObject(ApiResponse::class.java)
                .body as ApiResponse<*>

        assertEquals(StatusCode.OK, response.code)

        println(JsonSerializer.asJson(response))
    }

    @Test
    fun testPasswordVerifyResponseCodeIsNotImplemented() {
        val response: ApiResponse<*> = Unirest.get("http://localhost:8080/password/verify")
                .queryString("user", "John")
                .queryString("pass", "xxx")
                .asObject(ApiResponse::class.java)
                .body as ApiResponse<*>

        assertEquals(StatusCode.OK, response.code)

        println(JsonSerializer.asJson(response))
    }

    @Test
    fun testStatisticsOperationsCountResponseCodeIsNotImplemented() {
        val response: ApiResponse<*> = Unirest.get("http://localhost:8080/statistics/operationsCount")
                .asObject(ApiResponse::class.java)
                .body as ApiResponse<*>

        assertEquals(StatusCode.NOT_IMPLEMENTED, response.code)

        println(JsonSerializer.asJson(response))
    }

    @Test
    fun testStatisticsVerificationsLogResponseCodeIsNotImplemented() {
        val response: ApiResponse<*> = Unirest.get("http://localhost:8080/statistics/verificationsLog")
                .asObject(ApiResponse::class.java)
                .body as ApiResponse<*>

        assertEquals(StatusCode.NOT_IMPLEMENTED, response.code)

        println(JsonSerializer.asJson(response))
    }

}