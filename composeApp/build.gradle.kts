import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    sourceSets {
        
        androidMain.dependencies {
            implementation(libs.compose.ui.tooling.preview)
            implementation(libs.androidx.activity.compose)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            @OptIn(ExperimentalComposeLibrary::class)
            implementation(compose.components.resources)
            implementation(projects.shared)
        }
    }
}

android {
    namespace = "com.belovedev.rdv"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "com.belovedev.rdv"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    dependencies {
        debugImplementation(libs.compose.ui.tooling)
    }
}

dependencies {
    implementation(project(":shared"))

//    implementation("io.coil-kt.coil3:coil:3.0.0-alpha01")
//    implementation("io.coil-kt.coil3:coil-network-okhttp:3.0.0-alpha01")


    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui.tooling)
    implementation(libs.material3)
//    implementation("androidx.compose.material:material:1.5.4")
    implementation(libs.ui)
//    implementation(libs.m)

    // Decompose Libraries
    api(libs.decompose.decompose)
    api(libs.essenty.lifecycle)
    implementation(libs.decompose.extensionsComposeJetbrains)

    // Icons
//    implementation ("androidx.compose.material:material-icons-extended:1.5.1")

//    implementation ("io.coil-kt:coil-compose:1.4.0")
}

