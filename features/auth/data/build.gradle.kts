plugins {
    id("data-ktor-setup")
}

dependencies {
    api(project(Module.Features.Auth.domain))
}