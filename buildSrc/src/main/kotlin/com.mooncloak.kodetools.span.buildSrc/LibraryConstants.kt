@file:Suppress("MemberVisibilityCanBePrivate")

package com.mooncloak.kodetools.span.buildSrc

object LibraryConstants {

    const val group = "com.mooncloak.kodetools.span"
    const val owner = "mooncloak.kodetools"
    const val repoName = "span"
    const val versionName = "1.0.0-alpha01"

    val LibraryConstants.versionCode: Int
        get() = getCommitCount()

    val versionDescription = "Release $versionName ($versionCode)"
    const val license = "Apache-2.0"
    const val vcsUrl = "https://github.com/mooncloak/span.git"

    object Android {

        const val compileSdkVersion = 33
        const val minSdkVersion = 21
        const val targetSdkVersion = 33
    }
}
