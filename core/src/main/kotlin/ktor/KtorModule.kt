package ktor

import io.ktor.client.HttpClient
import org.koin.dsl.module

internal val ktorModule = module {
    single<HttpClient> {
        HttpClientFactory().createFactory(
            androidContext = get(),
            block = {},
            defaultRequestBlock = {}
        )
    }
}