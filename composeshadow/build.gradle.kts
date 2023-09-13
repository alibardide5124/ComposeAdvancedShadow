@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("composeshadow.library")
    `maven-publish`
}

group = ProjectConfig.group
version = ProjectConfig.versionName

publishing {
    publications {
        register<MavenPublication>(ProjectConfig.publication) {
            groupId = ProjectConfig.group
            artifactId = ProjectConfig.artifact
            version = ProjectConfig.versionName

            afterEvaluate {
                from(components[ProjectConfig.publication])
            }
        }
    }
}

android {
    namespace = ProjectConfig.namespace

    defaultConfig {
        renderscriptTargetApi = 34
        renderscriptSupportModeEnabled = true
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.version.get()
    }
    publishing {
        singleVariant(ProjectConfig.publication) {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

dependencies {
    implementation(libs.androidx.ktx)

    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)

    debugImplementation(libs.bundles.debug.compose)
}