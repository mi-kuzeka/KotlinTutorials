package com.example.kotlintutorials.shapes

import kotlin.math.roundToInt
import kotlin.random.Random

class Rectangle(
    val a: Double,
    val b: Double
) : Shape(name = "rectangle") {
    constructor(a: Double) : this(a, a)

    constructor(a: Int, b: Int) : this(a.toDouble(), b.toDouble())

    companion object {
        fun randomSquare(): Rectangle {
            val randomSide = Random.nextDouble(1.0, 6.0)
            return Rectangle(randomSide)
        }

        fun randomRectangle(): Rectangle {
            val randomSide1 = Random.nextInt(1, 6)
            val randomSide2 = Random.nextInt(1, 6)
            return Rectangle(randomSide1, randomSide2)
        }
    }

    init {
        println("The $name created with a=$a and b=$b")
    }

    override fun area() = a * b

    override fun perimeter() = 2 * a + 2 * b
}

fun Rectangle.printRectangle() {
    val rect = StringBuilder()
    val aInt = a.roundToInt()
    val bInt = b.roundToInt()
    for (i in 1..aInt) {
        for (j in 1..bInt) {
            when (i) {
                1, aInt -> rect.append("-")
                else -> {
                    when (j) {
                        1, bInt -> rect.append("|")
                        else -> rect.append(" ")
                    }
                }
            }
        }
        rect.appendLine()
    }
    println(rect)
}

fun Rectangle.isSquare() = this.a == this.b