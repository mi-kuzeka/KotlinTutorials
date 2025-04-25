package com.example.kotlintutorials.topics

internal object FunctionAsVariableTopic {
    internal fun functionAsVariableExample() {
        val printMyNameFunction = ::printMeMyName
        printMyNameFunction("Kuzepa")

        val printYourNameFunction = printMeYourName
        printYourNameFunction()

        val printHerNameFunction = printMeHerName("Angela")
        printHerNameFunction()
    }

    /*
    A normal function
     */
    private fun printMeMyName(name: String) {
        println("Your name is $name")
    }

    /*
    A variable that stores a lambda function
     */
    private val printMeYourName = {
        println("My name is Kotlin")
    }
    /*
    The code below is exactly the same as above
     */
//    private val printMeYourName: () -> Unit = {
//        println("My name is Kotlin")
//    }

    /*
    A lambda function
     */
    private fun printMeHerName(herName: String): () -> Unit = {
        println("Her name is $herName")
    }
}