package com.genesys.tpass

import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.genesys.tpass.api.PasswordResource
import com.genesys.tpass.api.StatisticsResource
import com.genesys.tpass.api.exceptionmappers.DefaultExceptionMapper
import com.genesys.tpass.api.exceptionmappers.KotlinIllegalArgumentExceptionMapper
import com.genesys.tpass.conf.TPassConfig
import com.google.common.base.Joiner
import com.google.common.io.Resources
import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import org.slf4j.LoggerFactory

/**
 *
 * @author rzinalie
 */
class TPassApplication : Application<TPassConfig>() {
    companion object {
        private val logger = LoggerFactory.getLogger(TPassApplication::class.java)

        @JvmStatic fun main(actualArgs: Array<String>) {
            try{
                val args: Array<String> = if (actualArgs.isNotEmpty()) actualArgs else
                    arrayOf("server", Resources.getResource("tpass.yml").path)

                logger.info("Running with args '{}'", Joiner.on(' ').join(args))

                TPassApplication().run(*args)
            }catch (e: Exception){
                logger.error("failed to start", e)
            }
        }
    }

    override fun run(configuration: TPassConfig?, environment: Environment?) {
        environment?.jersey()?.register(StatisticsResource())
        environment?.jersey()?.register(PasswordResource())

        environment?.jersey()?.register(DefaultExceptionMapper())
        environment?.jersey()?.register(KotlinIllegalArgumentExceptionMapper())

    }

    override fun initialize(bootstrap: Bootstrap<TPassConfig>?) {
        super.initialize(bootstrap)

        // Kotlin data classes support
        bootstrap?.objectMapper?.registerModule(KotlinModule())
    }
}