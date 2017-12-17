package com.genesys.tpass

import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.genesys.tpass.api.PasswordResource
import com.genesys.tpass.api.StatisticsResource
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

        @JvmStatic public fun main(actualArgs: Array<String>) {
            val args: Array<String> = if (actualArgs.size != 0) actualArgs else
                arrayOf("server", Resources.getResource("tpass.yml").path)

            logger.info("Running with args '{}'", Joiner.on(' ').join(args))

            TPassApplication().run(*args)
        }
    }

    override fun run(configuration: TPassConfig?, environment: Environment?) {
        environment?.jersey()?.register(StatisticsResource())
        environment?.jersey()?.register(PasswordResource())
    }

    override fun initialize(bootstrap: Bootstrap<TPassConfig>?) {
        super.initialize(bootstrap)

        bootstrap?.objectMapper?.registerModule(KotlinModule())
    }
}