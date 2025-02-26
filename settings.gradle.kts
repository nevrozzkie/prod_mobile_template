
pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
//    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }

}

rootProject.name = "MobileTemplate"
include(":app")
include(":core")
include(":utils")
include(":utils-ui")
include(":features:auth:data")
include(":features:auth:domain")
include(":features:auth:presentation")
include(":features:auth:ui")


