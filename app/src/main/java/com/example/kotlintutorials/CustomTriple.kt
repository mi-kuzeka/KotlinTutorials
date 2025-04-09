package com.example.kotlintutorials

/**
 * Any - non-nullable
 * Any? - nullable
 */
class CustomTriple<A: Any, B: Any, C: Any>(
    var first: A,
    var second: B,
    var third: C
) {
    fun printTypes() {
        println("The type of the first is ${first::class}")
        println("The type of the second is ${second::class}")
        println("The type of the third is ${third::class}")
    }
}