import org.jetbrains.compose.ExperimentalComposeLibrary

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinParcelize)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.sqldelight)
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
        }
    }
    
    sourceSets {
        commonMain.dependencies {
            with(compose) {
                implementation(runtime)
                implementation(foundation)
                implementation(material)
                implementation(material3)
                implementation(materialIconsExtended)

                @OptIn(ExperimentalComposeLibrary::class)
                implementation(components.resources)
            }
//
//            implementation(libs.ui.tooling)
//            implementation(libs.ui.tooling.preview)
//
            implementation(libs.koin.core)
////            api(libs.koin.android)
//
            implementation(libs.coroutine.core)
            implementation(libs.kotlin.serialization)

            api(libs.arkivanov.mvikotlin)
            api(libs.arkivanov.mvikotlin.main)
            api(libs.arkivanov.mvikotlin.ext.coroutine)
//
            implementation(libs.decompose.decompose)
            implementation(libs.decompose.extensionsComposeJetbrains)
            implementation(libs.essenty.lifecycle)

//            api(libs.sqldelight.coroutine.ext)
//            api(libs.sqldelight.primitive.adapter)
        }
    }
}

android {
    namespace = "com.belovedev.rdv.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}
