package ktor

import android.content.Context
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.call.HttpClientCall
import io.ktor.client.engine.cio.CIO
import io.ktor.client.engine.cio.CIOEngineConfig
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.cache.storage.FileStorage
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.statement.HttpReceivePipeline
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.Headers
import io.ktor.http.HeadersBuilder
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpProtocolVersion
import io.ktor.http.HttpStatusCode
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import io.ktor.util.date.GMTDate
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.InternalAPI
import kotlinx.serialization.json.Json
import java.io.File
import kotlin.coroutines.CoroutineContext

internal class HttpClientFactory {
    fun createFactory(
        androidContext: Context,
        block: HttpClientConfig<CIOEngineConfig>.() -> Unit = {},
        defaultRequestBlock: (DefaultRequest.DefaultRequestBuilder.() -> Unit)? = null
    ) =
        HttpClient(CIO) {
            this@HttpClient.block()

            install(HttpCache) {
                val dir = File(androidContext.dataDir, "ktor-cache")
                publicStorage(FileStorage(dir))
            }

            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }

            install(ContentNegotiation) {
                json(Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                    prettyPrint = true
                    this.coerceInputValues = true
                }, contentType = ContentType.Any)
            }
            install(HttpTimeout) {
                connectTimeoutMillis = 15000
                requestTimeoutMillis = 30000
            }
            defaultRequest {

                url {

                    protocol = URLProtocol.HTTPS
                }
                port = 443
                defaultRequestBlock?.let { it() }
            }
        }


}

