package com.benliger.adventofcode.day01

import kotlin.math.absoluteValue

fun main() {
    // Part 1
    val sortedListA = listA.sorted()
    val sortedListB = listB.sorted()

    var distance = 0
    sortedListA.forEachIndexed { index, dataA ->
        val dataB = sortedListB[index]
        distance += (dataB - dataA).absoluteValue
    }
    println("result is $distance")

    // Part 2
    var similarity = 0
    listA.forEach { dataA ->
        val countOfSimilarNumberInB = listB.count { it == dataA }
        similarity += (countOfSimilarNumberInB * dataA)
    }
    println("result is $similarity")
}