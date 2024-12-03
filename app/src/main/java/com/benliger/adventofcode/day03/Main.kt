package com.benliger.adventofcode.day03

import java.io.File

fun main() {
    val input = inputFromFile() ?: return
    val regex = Regex("""mul\((\d+),(\d+)\)""")
    var result = 0
    input.lines().forEach {
        val matchResults = regex.findAll(it)
        matchResults.forEach { matchResult ->
            val multA = matchResult.groups[1]?.value?.toInt() ?: 0
            val multB = matchResult.groups[2]?.value?.toInt() ?: 0
            result += (multA * multB)
        }
    }
    println("Result of program is $result")
}

private fun inputFromFile(): String? {
    val fileName = "app/src/main/java/com/benliger/adventofcode/day03/input"
    val file = File(fileName)

    if (file.exists()) {
        return file.readText()
    } else {
        println("File not found: $fileName")
        return null
    }
}