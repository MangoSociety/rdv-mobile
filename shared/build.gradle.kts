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
//            implementation(libs.koin.core)
////            api(libs.koin.android)
//
            implementation(libs.coroutine.core)
            implementation(libs.kotlin.serialization)

//            implementation("io.coil-kt.coil3:coil:3.0.0-alpha01")
//            implementation("io.coil-kt.coil3:coil-network-okhttp:3.0.0-alpha01")


            api(libs.arkivanov.mvikotlin)
            api(libs.arkivanov.mvikotlin.main)
            api(libs.arkivanov.mvikotlin.ext.coroutine)
            implementation(libs.decompose.decompose)
            implementation(libs.decompose.extensionsComposeJetbrains)
            implementation(libs.essenty.lifecycle)

            implementation("io.coil-kt.coil3:coil-compose:3.0.0-alpha06")
            implementation("io.coil-kt.coil3:coil-network-ktor:3.0.0-alpha06")
        }

        androidMain.dependencies {
            implementation("io.ktor:ktor-client-okhttp:2.3.7")
        }

        iosMain.dependencies {
            implementation("io.ktor:ktor-client-darwin:2.3.7")
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
