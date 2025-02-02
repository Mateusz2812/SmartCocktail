import com.android.build.api.dsl.BaseFlavor
import com.android.build.gradle.internal.dsl.ProductFlavor
import org.gradle.api.Action

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.ksp)
}

android {
    namespace = "com.smartCocktails.smartcocktail"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.smartCocktails.smartcocktail"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isDebuggable = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }

    flavorDimensions +="version"

    productFlavors {
        create("dev"){
            isDefault = true
            applicationIdSuffix =".dev"
            resValue("string", "app_name", "Smart Coctails (Dev)")
            buildConfigField("String", "SERVER_URL", "\"https://www.thecocktaildb.com/api/json/v1/1/\"")
        }

        create("prod"){
            applicationIdSuffix =".prod"
            resValue("string", "app_name", "Smart Coctails")
            buildConfigField("String", "SERVER_URL", "\"https://www.thecocktaildb.com/api/json/v1/1/\"")
        }

        create("tst"){
            applicationIdSuffix =".tst"
            resValue("string", "app_name", "Smart Coctails (TST)")
            buildConfigField("String", "SERVER_URL", "\"https://www.thecocktaildb.com/api/json/v1/1/\"")
        }
    }
}

androidComponents{
    finalizeDsl { ext ->
        ext.productFlavors.forEach {
            val flavorName = it.name.uppercase()
            it.buildConfigField("boolean", "IS_$flavorName", "true")
            ext.productFlavors.forEach { otherFlavor ->
                if (otherFlavor != it) {
                    val otherFlavorName = otherFlavor.name.uppercase()
                    it.buildConfigField("boolean", "IS_$otherFlavorName", "false")
                }
            }
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(project(":core"))
    implementation(project(":home"))
    implementation(project(":login"))
    implementation(project(":order"))
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}