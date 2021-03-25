import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.konan.properties.Properties

plugins {
    id("com.dipien.releaseshub.gradle.plugin") version "2.0.1"
}

buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(BuildLibs.ANDROID_GRADLE_PLUGIN)
        classpath(BuildLibs.KOTLIN_PLUGIN)
        classpath(BuildLibs.NAVIGATION_SAVE_ARGS_PLUGIN)
        classpath(BuildLibs.HILT_PLUGIN)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

subprojects {
    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions.freeCompilerArgs +=
            "-Xuse-experimental=" +
                    "kotlin.Experimental," +
                    "kotlinx.coroutines.ExperimentalCoroutinesApi," +
                    "kotlinx.coroutines.InternalCoroutinesApi," +
                    "kotlinx.coroutines.FlowPreview"
        kotlinOptions.jvmTarget = "1.8"
    }
}

tasks.register("upgradeDependencies1", tasks.UpgradeDependencies::class.java)

releasesHub {
    dependenciesBasePath = "buildSrc/src/main/kotlin/"
    dependenciesClassNames = listOf("Libs.kt", "BuildLibs.kt")
    excludes = listOf("gradle")

    pullRequestEnabled = true

    gitHubRepositoryOwner = "kkgosu"
    gitHubRepositoryName = "Sberify"

    val properties = Properties()
    properties.load(project.rootProject.file("local.properties").inputStream())
    val token = properties.getProperty("github_token")

    gitHubWriteToken = token
}
