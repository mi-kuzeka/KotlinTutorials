package com.example.kotlintutorials.shapes

import kotlin.math.sqrt

class Triangle(
    val a: Double,
    val b: Double,
    val c: Double,
) : Shape("triangle") {
    init {
        println("The $name created with a = $a, b = $b, c = $c")
    }

    override fun area(): Double {
        val halfOfPerimeter: Double = perimeter() / 2
        return sqrt(
            halfOfPerimeter * (halfOfPerimeter - a)
                    * (halfOfPerimeter - b) * (halfOfPerimeter - c)
        )
    }

    override fun perimeter() = a + b + c
}