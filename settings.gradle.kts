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
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "it-courses-learning"
include(":app")
include(":feature:mainScreen")
include(":ui-kit")
include(":network")
include(":navigation")
include(":local")
include(":feature:favourites")
include(":shared:model")
include(":feature:courseScreen")
include(":feature:account")
