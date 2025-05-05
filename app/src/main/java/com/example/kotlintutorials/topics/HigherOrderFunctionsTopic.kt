package com.example.kotlintutorials.topics

import kotlin.math.roundToInt

object HigherOrderFunctionsTopic {
    private class Cookie(
        val name: String,
        val softBaked: Boolean,
        val hasFilling: Boolean,
        val price: Double
    )

    private val cookies = listOf(
        Cookie(
            name = "Chocolate Chip",
            softBaked = false,
            hasFilling = false,
            price = 1.69
        ),
        Cookie(
            name = "Banana Walnut",
            softBaked = true,
            hasFilling = false,
            price = 1.49
        ),
        Cookie(
            name = "Vanilla Creme",
            softBaked = false,
            hasFilling = true,
            price = 1.59
        ),
        Cookie(
            name = "Chocolate Peanut Butter",
            softBaked = false,
            hasFilling = true,
            price = 1.49
        ),
        Cookie(
            name = "Snickerdoodle",
            softBaked = true,
            hasFilling = false,
            price = 1.39
        ),
        Cookie(
            name = "Blueberry Tart",
            softBaked = true,
            hasFilling = true,
            price = 1.79
        ),
        Cookie(
            name = "Sugar and Sprinkles",
            softBaked = false,
            hasFilling = false,
            price = 1.39
        )
    )

    fun sortedByFunction() {
        val alphabeticalMenu = cookies.sortedBy {
            it.name
        }
        println("Alphabetical menu:")
        alphabeticalMenu.forEach {
            println(it.name)
        }
    }

    fun sumOfFunction() {
        val cookiePrice = cookies.map { it.price }
        val totalPrice = cookiePrice.sum()
        println("Total price: $$totalPrice")

        val totalPriceWithInflationAndTax = cookiePrice.sumOf {
            it * 1.15 + 0.25
        }
        println("Total price adjusted for inflation: \$$totalPriceWithInflationAndTax")
    }

    fun reduceFunction() {
        val cookiesPrice = cookies.map { it.price }
        val totalPrice = cookiesPrice.reduce { total, price ->
            total + price
        }
        println("Total price: $$totalPrice")
    }

    fun foldFunction() {
        val totalPrice = cookies.fold(0.0) { total, cookie ->
            total + cookie.price
        }

        println("Total price: $$totalPrice")
    }

    fun partitionFunction() {
        val array = intArrayOf(1, 2, 3, 4, 5)
        val (even, odd) = array.partition { it % 2 == 0 }
        println(even) // [2, 4]
        println(odd) // [1, 3, 5]

        val (softBakedMenu, crunchyMenu) = cookies.partition {
            it.softBaked
        }

        println("Soft cookies:")
        softBakedMenu.forEach {
            println("${it.name} - $${it.price}")
        }
        println("---------------------")
        println("Crunchy cookies:")
        crunchyMenu.forEach {
            println("${it.name} - $${it.price}")
        }
    }

    fun groupByFunction() {
        // The return type will be Map<Boolean, List<Cookie>>
        val groupedMenu = cookies.groupBy {
            it.softBaked
        }
        val softBakedMenu = groupedMenu[true] ?: emptyList()
        val crunchyMenu = groupedMenu[false] ?: emptyList()

        println("Soft cookies:")
        softBakedMenu.forEach {
            println("${it.name} - $${it.price}")
        }
        println("---------------------")
        println("Crunchy cookies:")
        crunchyMenu.forEach {
            println("${it.name} - $${it.price}")
        }
    }

    fun filterFunctionExample() {
        val softBakedMenu = cookies.filter {
            it.softBaked
        }
        println("Soft cookies:")
        softBakedMenu.forEach {
            println("${it.name} - $${it.price}")
        }
    }

    fun mapFunctionExample() {
        val fullMenu = cookies.map {
            "${it.name} - $${it.price}"
        }

        println("Full menu:")
        fullMenu.forEach {
            println(it)
        }
    }

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