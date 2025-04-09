package com.example.kotlintutorials.topics

import com.example.kotlintutorials.shapes.Circle

object ExceptionTopic {
    fun negativeRadiusExceptionExample() {
        val circle = try {
            Circle(-5.4)
        } catch (e: Circle.NegativeRadiusException) {
            Circle(1.0)
        }
        println("The radius set successfully!")
    }

    fun customExceptionExample() {
        val division = try {
            divide(5.0, 0.0)
        } catch (e: DivisionByZeroException) {
            0.0
        }

        println(division)
    }

    fun exceptionExample() {
        println("How many apples do you want to eat?")
        val input = try {
            readlnOrNull()?.toInt()
        } catch (e: NumberFormatException) {
            0
        } finally {
            println("We have counted your apples!")
        }

        println("You will eat $input apples")
    }

    class DivisionByZeroException :
        Exception("You cannot divide by zero. Please choose a different number")

    fun divide(a: Double, b: Double): Double {
        if (b == 0.0) throw DivisionByZeroException()
        return a / b
    }
}