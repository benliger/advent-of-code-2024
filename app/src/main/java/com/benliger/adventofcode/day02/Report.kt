package com.benliger.adventofcode.day02

data class Report(val levels: List<Int>) {

    /**
    The levels are either all increasing or all decreasing.
    Any two adjacent levels differ by at least one and at most three.
     */
    fun isSafe(): Boolean {
        if (levels.size < 2) return false
        if (levels != levels.sorted() && levels != levels.sortedDescending()) return false

        var currentValue = levels.first()
        for (i in 1 until levels.size) {
            val nextValue = levels[i]
            if (nextValue == currentValue) return false

            if (currentValue !in nextValue - 3..nextValue + 3) return false
            currentValue = nextValue
        }
        return true
    }

    /**
     * Report is safe if it is safe or if it is safe with one level removed.
     */
    fun isSafeWithTolerance(): Boolean {
        if (isSafe()) return true

        levels.forEachIndexed { index, _ ->
            val newLevels = levels.toMutableList()
            newLevels.removeAt(index)
            val newReport = copy(levels = newLevels)
            if (newReport.isSafe()) return true
        }
        return false
    }

}
