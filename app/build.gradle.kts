import org.jetbrains.kotlin.storage.CacheResetOnProcessCanceled.enabled

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.charlye934.shoppinliverpool"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.charlye934.shoppinliverpool"
        minSdk = 33
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField("String", "BASE_URL","\"https://shoppapp.liverpool.com.mx/appclienteservices/services/v7/\"")
    }

    buildTypes {
        debug {
            applicationIdSuffix = ".debug"
        }
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    //RETROFIT
    implementation(libs.gson)
    implementation(libs.retrofit)
    implementation(libs.retrofit.convert)

    //OKHTTP
    implementation(libs.okhttp)
    implementation(libs.okhttp.login.interceptor)
    implementation(libs.okhttp.url.conecction)

    //VIEWMODEL
    implementation(libs.viewmodel)
    implementation(libs.livedata)
    implementation(libs.coroutines)

    //HILT
    implementation(libs.hilt)

    //NAVIGATION
    implementation(libs.navigation.ui)
    implementation(libs.navigation.fragment)

    //Glide
    implementation(libs.glide)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}