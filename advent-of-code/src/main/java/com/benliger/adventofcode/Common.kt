package com.benliger.adventofcode

import java.io.File

fun inputFromFile(fileName: String): String? {
    val file = File(fileName)

    if (file.exists()) {
        return file.readText().lines().joinToString()
    } else {
        println("File not found: $fileName")
        return null
    }
}