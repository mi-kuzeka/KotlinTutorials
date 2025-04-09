package com.example.kotlintutorials.topics

import com.example.kotlintutorials.Utils

object LoopsTopic {
    fun whereAreYouFrom() {
        println("Where are you from?")
        println(
            when (readlnOrNull()?.lowercase()) {
                "usa", "uk", "canada" -> "Hello"
                "russia", "belarus" -> "Privet"
                "spain", "mexico" -> "Hola"
                "germany" -> "Hallo"
                "india" -> "Namaste"
                "france" -> "Bonjour"
                else -> "Hello! Sorry, I don't know how to greet in your country."
            }
        )
    }

    fun whenLoopExample() {
        var finishProgramm = false
        while (!finishProgramm) {
            println("Enter your age")
            val age = Utils.readInt(
                true,
                "Please enter a positive integer number"
            )

            println(
                when (age) {
                    in 0..5 -> "You're a young kid"
                    in 6..17 -> "You're a teenager"
                    18 -> "Finally, you're 18!"
                    19, 20 -> "You're a young adult"
                    in 21..65 -> "You're an adult"
                    in 65..120 -> "You're really old"
                    else -> "Unbelievable!"
                }
            )

            println("Press 'f' to finish or enter to continue")
            val res = readln()
            if (res == "f") finishProgramm = true
        }
    }

    fun downToAlphabetLoopWithStepsExample() {
        for (i in 'z' downTo 'a' step 5) {
            println(i)
        }
    }

    fun downToNumberLoopWithStepsExample() {
        for (i in 10 downTo 1 step 2) {
            println(i)
        }
    }

    fun downToNumberLoopExample() {
        for (i in 10 downTo 1) {
            println(i)
        }
    }

    fun forLoopExample2() {
        for (i in 1..10) {
            println(i)
        }
    }

    fun forLoopExample1() {
        val myArray = arrayOf(1, 2, 3)
        for (i in myArray) {
            println(i)
        }
    }

    fun whileLoopExample() {
        var x = 10
        while (x > 0) {
            println(x)
            x--
        }
    }
}