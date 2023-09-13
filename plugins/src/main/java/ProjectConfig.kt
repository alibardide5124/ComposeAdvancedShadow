@file:Suppress("unused")

import org.gradle.api.JavaVersion
import org.gradle.jvm.toolchain.JavaLanguageVersion

object ProjectConfig {
    const val versionCode = 1
    const val versionName = "1.0.0"

    const val namespace = "com.alibardide.composeshadow"
    const val group = "com.github.alibardide5124"
    const val artifact = "ComposeShadows"
    const val publication = "release"

    const val compileSdk = 34
    const val targetSdk = 34
    const val minSdk = 21

    val javaCompileVersion = JavaVersion.VERSION_17
    private val javaCompileVersionText = javaCompileVersion.toString()
    val javaLanguageVersion: JavaLanguageVersion = JavaLanguageVersion.of(javaCompileVersionText)
    val kotlinJvmTarget = javaCompileVersionText
}
