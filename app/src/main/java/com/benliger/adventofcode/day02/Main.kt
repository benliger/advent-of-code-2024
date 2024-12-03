package com.benliger.adventofcode.day02

fun main() {
    val reports = input.toReports()
    val safeReportsCount = reports.count { it.isSafe() }
    println("$safeReportsCount reports are safe")

    val safeReportsWithToleranceCount = reports.count { it.isSafeWithTolerance() }
    println("$safeReportsWithToleranceCount reports are safe with a tolerance of 1 wrong level")
}

private fun String.toReports(): List<Report> = lines().map { line ->
    Report(levels = line.split(" ").map { it.toInt() })
}
