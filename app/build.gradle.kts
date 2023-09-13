@file:Suppress("UnstableApiUsage")

@Suppress(
    "DSL_SCOPE_VIOLATION",
    "MISSING_DEPENDENCY_CLASS",
    "UNRESOLVED_REFERENCE_WRONG_RECEIVER",
    "FUNCTION_CALL_EXPECTED"
)

plugins {
    id("composeshadow.application")
}

android {
    namespace = "${ProjectConfig.namespace}.sample"

    defaultConfig {
        applicationId = "${ProjectConfig.namespace}.sample"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.version.get()
    }
}

dependencies {
    implementation(projects.composeShadow)
    implementation(libs.compose.color.picker)
    implementation(libs.androidx.ktx)
    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)
    debugImplementation(libs.bundles.debug.compose)
}