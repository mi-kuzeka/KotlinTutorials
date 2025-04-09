package com.example.kotlintutorials.topics

import com.example.kotlintutorials.shapes.Shape
import com.example.kotlintutorials.shapes.TrapezoidSides
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.random.Random

object AnonymousClassesTopic {
    fun createNewShape() {
        val a = Random.nextDouble(1.0, 8.0)
        val b = Random.nextDouble(1.0, 8.0)
        val height = Random.nextDouble(1.0, 8.0)
        val parallelogram = object : Shape("parallelogram", a, b, height) {
            init {
                println("The $name created with a=$a, b=$b, height=$height")
            }

            override fun area(): Double {
                return b * height
            }

            override fun perimeter(): Double {
                return 2 * (a + b)
            }

            fun isRectangle(): Boolean = height == a
            fun isSquare(): Boolean = height == a && a == b
        }
        parallelogram.printData()
        if (parallelogram.isSquare()) {
            println("Parallelogram is square")
        } else if (parallelogram.isRectangle()) {
            println("Parallelogram is rectangle")
        } else {
            println("Parallelogram isn't rectangle")
        }
    }

    fun createNewIntShape() {
//    val trapezoidSides = getRandomTrapezoidData()
//    val trapezoidSides = TrapezoidSides(4.0, 8.0, 5.0, 4.0, 4.0)
//    val trapezoidSides = TrapezoidSides(8.0, 8.0, 4.0, 4.0, 4.0)
        val trapezoidSides = TrapezoidSides(4.0, 4.0, 4.0, 4.0, 4.0)
        val trapezoid = object : Shape(
            "parallelogram",
            trapezoidSides.aBase,
            trapezoidSides.bBase,
            trapezoidSides.c,
            trapezoidSides.d,
            trapezoidSides.height
        ) {
            init {
                println(
                    "The ${super.name} created with a=${trapezoidSides.aBase}, " +
                            "b=${trapezoidSides.bBase}, c=${trapezoidSides.c}, " +
                            "d=${trapezoidSides.d}, height=${trapezoidSides.height}"
                )
            }

            override fun area(): Double {
                return ((trapezoidSides.aBase + trapezoidSides.bBase) / 2) *
                        trapezoidSides.height
            }

            override fun perimeter(): Double {
                return trapezoidSides.aBase + trapezoidSides.bBase +
                        trapezoidSides.c + trapezoidSides.d
            }

            fun isSquare() = (trapezoidSides.aBase == trapezoidSides.height)
                    && (trapezoidSides.c == trapezoidSides.d)
                    && (trapezoidSides.c == trapezoidSides.height)

            fun isRectangle() = (trapezoidSides.c == trapezoidSides.d)
                    && (trapezoidSides.c == trapezoidSides.height)
        }
        trapezoid.printData()
        if (trapezoid.isSquare()) {
            println("The trapezoid is square")
        } else if (trapezoid.isRectangle()) {
            println("The trapezoid is rectangle")
        } else {
            println("The trapezoid isn't rectangle")
        }
    }

    fun getRandomTrapezoidData(): TrapezoidSides {
        val aBase = Random.nextInt(1, 12)
        val bBase = Random.nextInt(1, 12)
        val height = Random.nextInt(1, 12)
        val hDouble = height.toDouble()
        val sumOfTempSides = abs(aBase - bBase)
        if (sumOfTempSides == 0) {
            return TrapezoidSides(
                aBase.toDouble(), bBase.toDouble(), hDouble, hDouble, hDouble
            )
        }
        val randomSide1 = if (sumOfTempSides == 1) 1 else Random.nextInt(1, sumOfTempSides)
        val randomSide2 = sumOfTempSides - randomSide1
        val c = sqrt(randomSide1.toDouble().pow(2) + height.toDouble().pow(2))
        val d: Double
        if (randomSide2 == 0) {
            d = hDouble
        } else {
            d = sqrt(randomSide2.toDouble().pow(2) + height.toDouble().pow(2))
        }

        return TrapezoidSides(aBase.toDouble(), bBase.toDouble(), c, d, hDouble)
    }
}