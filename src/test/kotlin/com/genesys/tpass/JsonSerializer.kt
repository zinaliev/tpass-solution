package com.genesys.tpass

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature

/**
 *
 * @author rzinalie
 */
class JsonSerializer {
    companion object {

        private val MAPPER = ObjectMapper()

        init {
            MAPPER.enable(SerializationFeature.INDENT_OUTPUT)
        }

        fun asJson(obj: Any) : String{
            return MAPPER.writeValueAsString(obj)
        }
    }
}