plugins {
    `kotlin-dsl`
}

buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    //todo sync with BuildLibs
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.38.1")
    }
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}