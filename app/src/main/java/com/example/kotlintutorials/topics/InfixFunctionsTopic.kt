package com.example.kotlintutorials.topics

object InfixFunctionsTopic {
    fun infixExample() {
        val zvan = "3v" customPlus "an"
        println(zvan)
        var sum = 5 customPlus 14
        sum = sum.customPlus(1)
        println(sum)
    }

    infix fun Int.customPlus(a:Int):Int = this + a

    infix fun String.customPlus(tale: String): String = this + tale
}