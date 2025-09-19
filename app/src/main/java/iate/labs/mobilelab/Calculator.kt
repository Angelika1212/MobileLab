package iate.labs.mobilelab

import kotlin.random.Random


class Calculator {
    fun calculateAverage(generatedList: List<Int>): Double {
        return generatedList
            .filterIndexed { index, value -> index % 2 != 0 && value % 2 == 0 }
            .average()
    }

    fun getGenerateArray(): List<Int> {
        return IntArray(10) { Random.nextInt(1, 1000) }.asList();
    }
}