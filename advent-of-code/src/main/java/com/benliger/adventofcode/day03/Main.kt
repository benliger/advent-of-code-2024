package com.benliger.adventofcode.day03

import com.benliger.adventofcode.inputFromFile

fun main() {
    val input = inputFromFile(fileName = "app/src/main/java/com/benliger/adventofcode/day03/input") ?: return

    // part 1
    val result = input.executeMultiplicationInstructions()
    println("Result of program is $result")

    // part 2
    val resultWithActiveInstructions =
        input.removeInactivePartOfProgram().executeMultiplicationInstructions()
    println("Result of program with active instructions is $resultWithActiveInstructions")
}

private fun String.executeMultiplicationInstructions(): Int {
    val regex = Regex("""mul\((\d+),(\d+)\)""")
    var result = 0
    val matchResults = regex.findAll(this)
    matchResults.forEach { matchResult ->
        val multiplicand = matchResult.groups[1]?.value?.toInt() ?: 0
        val multiplier = matchResult.groups[2]?.value?.toInt() ?: 0
        result += multiplicand * multiplier
    }
    return result
}

private fun String.removeInactivePartOfProgram(): String {
    val inactiveInstructions = Regex("""(don't\(\).*?(do\(\)))""")
    val text = inactiveInstructions.replace(this, "")
    return text.substringBeforeLast("don't()")
}