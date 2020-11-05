import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.releaseshub.gradle.plugin") version "1.6.1"
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
    }
}

releasesHub {
    dependenciesBasePath = "buildSrc/src/main/java/"
    dependenciesClassNames = listOf("Libs.kt", "BuildLibs.kt")

}
