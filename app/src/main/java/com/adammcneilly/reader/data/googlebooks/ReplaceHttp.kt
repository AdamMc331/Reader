package com.adammcneilly.reader.data.googlebooks

/**
 * Some URLs returned by the Google Books api return a URL with just HTTP,
 * but those aren't rendering with our Coil library, so we'll force
 * them to use HTTPs.
 */
fun String.forceHttps(): String {
    return this.replace("http://", "https://")
}
