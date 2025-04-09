package com.example.kotlintutorials.topics

import com.example.kotlintutorials.CustomTriple
import com.example.kotlintutorials.shapes.Circle
import com.example.kotlintutorials.shapes.Rectangle
import com.example.kotlintutorials.shapes.Triangle

object GenericsTopic {
    fun numberSumExample() {
        val list = (1..10).toList()
        println(list.customSum { it % 2 == 1 })
    }

    fun customTripleExample() {
        val triple = CustomTriple<Int, String, Boolean>(3,"Three", true)
        triple.printTypes()
        println("1. ${triple.first}")
        println("2. ${triple.second}")
        println("3. ${triple.third}")
    }

    fun severalGenericTypesExample() {
        val triple = Triple<Int, String, Boolean>(3,"Three", true)
        println("1. ${triple.first}")
        println("2. ${triple.second}")
        println("3. ${triple.third}")
    }

    fun shapesGenericExample() {
        val circle1 = Circle(5.0)
        val circle2 = Circle(3.5)
        val triangle1 = Triangle(4.0, 4.0, 4.0)
        val triangle2 = Triangle(3.0, 3.0, 3.0)
        val rectangle1 = Rectangle(6.0)
        val rectangle2 = Rectangle(4, 3)
        println("---------Creating a list...---------")
        var shapes = listOf(circle1, circle2, triangle1, triangle2, rectangle1, rectangle2)
        for (shape in shapes) {
            println("${shape.name}: area = ${shape.area()}")
        }
        println("---------Filtering the list...---------")
        shapes = shapes.customFilter { it.area() > 5.0 && it.area() < 50.0 }.sortedBy { it.area() }
        for (shape in shapes) {
            println("${shape.name}: area = ${shape.area()}")
        }
    }

    fun genericExample() {
        val integers = (1..20).toList().customFilter { it > 10 }
            .customNumberFilter { it % 3 == 0 }
        println(integers)
    }

    private inline fun <reified T : Number> List<T>.customSum(conditionFunction: (T) -> Boolean): T {
        var sum: T = 0 as T
        for (n in this) {
            if (conditionFunction(n)) sum = sum.plus(n) as T
        }
        return sum
    }

    operator fun Number.plus(other: Number): Number {
        return when (this) {
            is Long -> this.toLong() + other.toLong()
            is Int -> this.toInt() + other.toInt()
            is Short -> this.toShort() + other.toShort()
            is Byte -> this.toByte() + other.toByte()
            is Double -> this.toDouble() + other.toDouble()
            is Float -> this.toFloat() + other.toFloat()
            else -> throw RuntimeException("Unknown numeric type")
        }
    }

    private fun <T> List<T>.customFilter(filterFunction: (T) -> Boolean): List<T> {
        val resultList = mutableListOf<T>()
        for (item in this) {
            if (filterFunction(item)) resultList.add(item)
        }
        return resultList
    }

    private fun <T : Number> List<T>.customNumberFilter(filterFunction: (T) -> Boolean): List<T> {
        val resultList = mutableListOf<T>()
        for (item in this) {
            if (filterFunction(item)) resultList.add(item)
        }
        return resultList
    }
}