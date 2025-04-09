package com.example.kotlintutorials.topics

import com.example.kotlintutorials.getProduct
import com.example.kotlintutorials.isPrime

object ExtensionsTopic {
    fun printProductOfList() {
//    val list = listOf(5, 7, 3, 6, 10, 8, 1)
//    val list = listOf(1, 2, 3, 4, 5, 6)
//    val list = listOf(0, 1, 2, 3, 4, 6, 7, 8)
        val list = listOf(1, 2, 3, 4, 6, 7, 8)
        println("The list is $list")
        println("The product is ${list.getProduct()}")
    }

    fun checkIfTheNumberIsPrime() {
        println("Please enter a number")
        val input = readlnOrNull()?.toInt()

        if (input != null) {
            println("The number is ${if (input.isPrime()) "prime" else "not prime"}")
        }
    }
}