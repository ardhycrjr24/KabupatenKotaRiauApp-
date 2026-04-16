plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-parcelize")
}

android {
    namespace = "id.ac.smpn8bks.ardiansyah.kabupatenkotariauapp"
    compileSdk = 36

    defaultConfig {
        applicationId = "id.ac.smpn8bks.ardiansyah.kabupatenkotariauapp"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")

    implementation("androidx.recyclerview:recyclerview:1.3.2")

    implementation("com.github.bumptech.glide:glide:4.14.2")
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    annotationProcessor("com.github.bumptech.glide:compiler:4.14.2")

    implementation("de.hdodenhof:circleimageview:3.1.0")
    implementation("com.github.corouteam:GlideToVectorYou:2.0.0")
    implementation("com.github.MikeOrtiz:TouchImageView:1.4.1")
}