import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    sourceSets {
        
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            implementation("io.getstream:stream-webrtc-android-compose:1.0.7")
            implementation("io.getstream:stream-video-android-core:1.0.7")
            implementation("io.getstream:stream-video-android-ui-compose:1.0.7")
            implementation("io.coil-kt:coil-compose:2.6.0")
            implementation("com.squareup.retrofit2:retrofit:2.9.0")
            implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
            implementation("com.squareup.moshi:moshi-kotlin:1.12.0")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
            implementation("androidx.datastore:datastore-preferences:1.0.0")
            implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.3")
            implementation("com.google.code.gson:gson:2.8.9")
            implementation( "androidx.lifecycle:lifecycle-runtime-compose:2.4.0")
            implementation("com.google.pay.button:compose-pay-button:1.0.0")
            implementation("com.google.android.gms:play-services-wallet:latest")
            implementation("com.google.android.gms:play-services-tasks:latest")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:latest")
            implementation("com.stripe:stripe-android:20.48.1")
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation("org.jetbrains.androidx.navigation:navigation-compose:2.7.0-alpha07")
            implementation("org.jetbrains.androidx.lifecycle:lifecycle-viewmodel-compose:2.8.0")
        }
    }
}

android {
    namespace = "org.noctisdev.fifth"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "org.noctisdev.fifth"
        minSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
    dependencies {
        debugImplementation(compose.uiTooling)
    }
}

