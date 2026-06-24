plugins {
    // Maksud Codingan: Mengaktifkan plugin dasar untuk aplikasi Android dan compiler bahasa Kotlin
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    // Maksud Codingan: Mengaktifkan plugin KSP (Kotlin Symbol Processing) agar library Room database bisa menghasilkan kode otomatis tanpa eror compiler
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.maikelhulu0007.mobpro1"
    compileSdk = 35 // Maksud Codingan: Menggunakan SDK versi 35 agar mendukung fitur-fitur Jetpack Compose terbaru tahun 2026

    defaultConfig {
        applicationId = "com.maikelhulu0007.mobpro1"
        minSdk = 26     // Maksud Codingan: Memenuhi syarat minimum spesifikasi HP Android (API 26 / Android 8.0) sesuai rubrik tugas kuliah
        targetSdk = 34  // Maksud Codingan: Mengunci target ke SDK 34 agar aplikasi berjalan stabil dan aman
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        // Maksud Codingan: Menyetel keselarasan bahasa Java ke Versi 11 agar compiler tidak bentrok
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    
    kotlinOptions {
        // Maksud Codingan: Memaksa target compiler Kotlin ke Java 11 agar sinkron dengan konfigurasi compileOptions di atas
        jvmTarget = "11"
    }

    buildFeatures {
        // Maksud Codingan: Mengaktifkan fitur Jetpack Compose agar kita bisa membuat UI/Tampilan modern berbasis fungsi Kotlin
        compose = true
    }

    composeOptions {
        // Maksud Codingan: Menentukan versi compiler Compose yang cocok dengan versi Kotlin kita
        kotlinCompilerExtensionVersion = "1.5.3"
    }
}

dependencies {
    // Maksud Codingan: Library utama untuk merancang antarmuka (UI) menggunakan Jetpack Compose & Material 3 (desain standar Google)
    implementation("androidx.compose.ui:ui:1.7.0")
    implementation("androidx.compose.material3:material3:1.3.0")
    implementation("androidx.activity:activity-compose:1.10.0")
    
    // Maksud Codingan: Pustaka Room untuk mengelola database lokal secara offline di memori internal HP
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    // Maksud Codingan: Compiler khusus Room menggunakan KSP untuk memproses anotasi seperti @Entity dan @Dao
    ksp("androidx.room:room-compiler:2.6.1")

    // Maksud Codingan: Pustaka Retrofit untuk menangani koneksi internet dan mengambil data dari REST API luar
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
}