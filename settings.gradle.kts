pluginManagement {
    repositories {
        google()
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

rootProject.name = "Rustage"
include(":app")
include(":DamageCalculator")
include(":damagecalculator:domain")
include(":damagecalculator:data")
include(":damagecalculator:presentation")
