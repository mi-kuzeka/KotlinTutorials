package com.example.kotlintutorials.shapes

import kotlin.math.PI
import kotlin.math.pow
import kotlin.random.Random

class Circle(
    private val radius: Double
) : Shape("circle") {
    companion object {
        fun randomCircle(): Circle {
            val randomRadius = Random.nextDouble(1.0, 70.0)
            return Circle(randomRadius)
        }
    }

    init {
        if (radius < 0) throw NegativeRadiusException()
        println("The $name created with radius $radius")
        printData()
    }

    override fun area() = PI * radius.pow(2)

    override fun perimeter() = 2 * PI * radius

    class NegativeRadiusException :
        Exception("The radius cannot be negative. Please choose a different radius")
}