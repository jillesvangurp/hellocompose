plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

group = "com.jillesvangurp"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
    maven("https://maven.tryformation.com/releases") {
        content {
            includeGroup("com.jillesvangurp")
            includeGroup("com.tryformation")
        }
    }
}

kotlin {
    js(IR) {
        browser()
        binaries.executable()
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(compose.web.core)
                implementation(compose.runtime)

                implementation("com.tryformation:fluent-kotlin:_")
                implementation("com.jillesvangurp:search-client:_")
                implementation(KotlinX.serialization.json)

                implementation(Koin.core)


                implementation(npm("tailwindcss", "3.2.7")) // Official tailwindcss package
                implementation(npm("@tailwindcss/forms", "0.5.3"))
                implementation(npm("postcss", "8.4.21")) // CSS processor called postcss
                implementation(npm("autoprefixer", "10.4.14")) //parse CSS and add browser specific prefixes to CSS rules

                implementation(npm("style-loader", "3.3.1"))
                implementation(npm("css-loader", "6.7.3")) // required to handle @import/url() rules in CSS files
                implementation(npm("postcss-loader", "7.0.2")) // required to invoke postcss during bundling
                implementation(devNpm("cssnano", "5.1.15"))            }

        }
    }
}