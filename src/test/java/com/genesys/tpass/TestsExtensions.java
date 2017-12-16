package com.genesys.tpass;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class TestsExtensions {

    private final static ObjectMapper MAPPER;

    static {
        MAPPER = new ObjectMapper();
        MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public static String asJson(Object obj) throws Exception {
        return MAPPER.writeValueAsString(obj);
    }
}
