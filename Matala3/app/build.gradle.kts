import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.gms.google.services) apply false
}

val localProperties = Properties().apply {
    val localPropsFile = rootProject.file("local.properties")
    if (localPropsFile.exists()) {
        localPropsFile.inputStream().use { load(it) }
    }
}

val googleServicesPath = System.getenv("GOOGLE_SERVICES_JSON_PATH")
    ?: localProperties.getProperty("GOOGLE_SERVICES_JSON_PATH")
val googleServicesFile = file("google-services.json")

if (!googleServicesFile.exists() && !googleServicesPath.isNullOrBlank()) {
    val sourceFile = file(googleServicesPath)
    if (sourceFile.exists()) {
        sourceFile.copyTo(googleServicesFile, overwrite = true)
        logger.lifecycle("Loaded Firebase configuration from: $googleServicesPath")
    } else {
        logger.warn("GOOGLE_SERVICES_JSON_PATH is set but file was not found: $googleServicesPath")
    }
}

if (googleServicesFile.exists()) {
    apply(plugin = "com.google.gms.google-services")
} else {
    logger.lifecycle("google-services.json not found. Firebase will not be fully configured until you provide it via GOOGLE_SERVICES_JSON_PATH or app/google-services.json.")
}

android {
    namespace = "com.example.matala3"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.matala3"
        minSdk = 24
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
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    implementation(libs.firebase.auth)
    implementation(libs.firebase.firestore)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
