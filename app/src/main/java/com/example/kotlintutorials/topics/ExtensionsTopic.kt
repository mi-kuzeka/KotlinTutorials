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

    fun extensionPropertyExample() {
        println(Quiz.progressText)
    }

    /*
    NOTE: Extension properties can't store data, so they must be get-only.
     */
    private val Quiz.StudentProgress.progressText: String
        get() = "$answered of $total answered."

    private data class Question<T>(
        val questionText: String,
        val answer: T,
        val difficulty: Difficulty
    )

    private enum class Difficulty {
        EASY, MEDIUM, HARD
    }

    private class Quiz {
        val question1 = Question(
            questionText = "Quoth the raven ___",
            answer = "nevermore",
            difficulty = Difficulty.MEDIUM
        )
        val question2 = Question(
            questionText = "The sky is green. True or false",
            answer = false,
            difficulty = Difficulty.EASY
        )
        val question3 = Question(
            questionText = "How many days are there between full moons?",
            answer = 28,
            difficulty = Difficulty.HARD
        )

        companion object StudentProgress {
            val total: Int = 10
            val answered: Int = 3
        }
    }
}