package com.example.kotlintutorials.topics

import kotlin.math.roundToInt

object HigherOrderFunctionsTopic {
    fun repeatFunctionExample() {
        repeat(5) { println("$it. He-he") }
    }

    fun groupingFold() {
        val fruits = listOf("apple", "apricot", "banana", "blueberry", "cherry", "coconut")
        // collect only even length Strings
        val evenFruits = fruits.groupingBy { it.first() }
            .fold(listOf<String>()) { accumulator, element ->
                if (element.length % 2 == 0) accumulator + element else accumulator
            }
        println(evenFruits)
    }

    fun foldExample() {
        val numbers = listOf(1, 2, 3, 4, 5, 10)
//        val sum = numbers.fold(0) { acc, i -> acc + i }
        val sum = numbers.reduce { acc, i -> acc + i }
        println(sum)
    }

    fun runExample() {
//        val res = getResultString(5.0, 6.0, ::add)
        val res = getRoundedToIntResultString(5.7, 6.0, ::add)
        println(res)
    }

    fun add(a: Double, b: Double): Double {
        return a + b
    }

    private fun getRoundedToIntResultString(
        a: Double, b: Double,
        fn: (Double, Double) -> Double
    ): String {
        return "The result is ${fn(a, b).roundToInt()}"
    }
}