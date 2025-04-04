import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("plugin.serialization")
    id("com.android.library")
    id("org.jetbrains.dokka")
    id("textx.multiplatform")
    id("textx.publish")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.compose")
}

kotlin {
    sourceSets {
        all {
            // Disable warnings and errors related to these expected @OptIn annotations.
            // See: https://kotlinlang.org/docs/opt-in-requirements.html#module-wide-opt-in
            languageSettings.optIn("kotlin.RequiresOptIn")
            languageSettings.optIn("-Xexpect-actual-classes")
        }

        val commonMain by getting {
            dependencies {
                api(project(":textx-core"))

                // Coroutines
                // https://github.com/Kotlin/kotlinx.coroutines
                implementation(KotlinX.coroutines.core)

                // Serialization
                // https://github.com/Kotlin/kotlinx.serialization
                implementation(KotlinX.serialization.core)

                // Declarative UI - Compose Multiplatform
                implementation(compose.runtime)
                implementation(compose.ui)
                implementation(compose.material3)

                // compose serialization
                // https://github.com/mooncloak/compose-serialization
                implementation("com.mooncloak.kodetools.compose.serialization:compose-serialization-core:_")

                // Markdown Rendering
                // https://github.com/mikepenz/multiplatform-markdown-renderer
                implementation("com.mikepenz:multiplatform-markdown-renderer-m3:_")

                // HTML
                // https://github.com/MohamedRejeb/Ksoup
                implementation("com.mohamedrejeb.ksoup:ksoup-html:_")
                implementation("com.mohamedrejeb.ksoup:ksoup-entities:_")
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

android {
    compileSdk = BuildConstants.Android.compileSdkVersion
    namespace = "com.mooncloak.kodetools.textx.ui"

    defaultConfig {
        minSdk = BuildConstants.Android.minSdkVersion
        targetSdk = BuildConstants.Android.targetSdkVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
            // Opt-in to experimental compose APIs
            freeCompilerArgs = listOf(
                "-Xopt-in=kotlin.RequiresOptIn"
            )
        }
    }
}
