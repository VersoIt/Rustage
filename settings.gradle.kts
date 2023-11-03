pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        jcenter()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Rustage"
include(":app")
include(":damagecalculator")
include(":damagecalculator:domain")
include(":damagecalculator:presentation")
include(":damagecalculator:data")
