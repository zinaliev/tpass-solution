package com.genesys.tpass;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.genesys.tpass.api.dto.ApiResponseDto;
import com.genesys.tpass.api.dto.OperationsCountDto;
import com.genesys.tpass.api.dto.PasswordDto;
import com.genesys.tpass.api.dto.StatusCode;
import com.genesys.tpass.api.dto.VerificationAttemptDto;
import com.genesys.tpass.api.dto.VerificationResultDto;
import com.google.common.io.Resources;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TPassApplicationIT {

    private final static String APP_MODE = "server";

    @BeforeClass
    public static void setUpAll() throws Exception {
        setUpServer();
        setUpClient();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        Unirest.shutdown();
    }

    private static void setUpServer() throws Exception {
        String[] applicationArgs = new String[2];
        applicationArgs[0] = APP_MODE;
        applicationArgs[1] = Resources.getResource("tpass-test.yml").getPath();


        new TPassApplication().run(applicationArgs);
    }

    private static void setUpClient() {

        Unirest.setObjectMapper(new ObjectMapper() {
            private final com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    @Test
    public void testPasswordCreate_ExternalCall_ResponseCodeIsNotImplemented() throws Exception {
        ApiResponseDto<PasswordDto> response = Unirest.get("http://localhost:8080/password/create")
                .queryString("user", "John")
                .queryString("timeout", 10)
                .asObject(ApiResponseDto.class)
                .getBody();

        assertEquals(StatusCode.NOT_IMPLEMENTED, response.getCode());
        System.out.println(TestsExtensions.asJson(response));
    }

    @Test
    public void testPasswordVerify_ExternalCall_ResponseCodeIsNotImplemented() throws Exception {
        ApiResponseDto<VerificationResultDto> response = Unirest.get("http://localhost:8080/password/verify")
                .queryString("user", "John")
                .queryString("pass","xxx")
                .asObject(ApiResponseDto.class)
                .getBody();

        assertEquals(StatusCode.NOT_IMPLEMENTED, response.getCode());
        System.out.println(TestsExtensions.asJson(response));
    }

    @Test
    public void testStatisticsOperationsCount_ExternalCall_ResponseCodeIsNotImplemented() throws Exception {
        ApiResponseDto<OperationsCountDto> response = Unirest.get("http://localhost:8080/statistics/operationsCount")
                .asObject(ApiResponseDto.class)
                .getBody();

        assertEquals(StatusCode.NOT_IMPLEMENTED, response.getCode());
        System.out.println(TestsExtensions.asJson(response));
    }

    @Test
    public void testStatisticsVerificationsLog_ExternalCall_ResponseCodeIsNotImplemented() throws Exception {
        ApiResponseDto<VerificationAttemptDto[]> response = Unirest.get("http://localhost:8080/statistics/verificationsLog")
                .queryString("count", 100)
                .asObject(ApiResponseDto.class)
                .getBody();

        assertEquals(StatusCode.NOT_IMPLEMENTED, response.getCode());
        System.out.println(TestsExtensions.asJson(response));
    }
}