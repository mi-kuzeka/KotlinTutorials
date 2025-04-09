package com.example.kotlintutorials.topics

import com.example.kotlintutorials.shapes.Circle
import com.example.kotlintutorials.shapes.Rectangle
import com.example.kotlintutorials.shapes.Shape
import com.example.kotlintutorials.shapes.Triangle

object LambdaTopic {
    fun filteredSum() {
        val list = (1..10).toList()
        println(list.customSum { it % 2 == 1 })
    }

    fun filterShapes() {
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
        shapes = shapes.customFilter { it.area() > 20.0 }.sortedBy { it.area() }
        for (shape in shapes) {
            println("${shape.name}: area = ${shape.area()}")
        }
    }

    private fun List<Shape>.customFilter(filterFunction: (Shape) -> Boolean): List<Shape> {
        val resultList = mutableListOf<Shape>()
        for (shape in this) {
            if (filterFunction(shape)) resultList.add(shape)
        }
        return resultList
    }

    private fun List<Int>.customSum(conditionFunction: (Int) -> Boolean): Int {
        var sum = 0
        for (n in this) {
            if (conditionFunction(n)) sum += n
        }
        return sum
    }

    fun lambdaExample() {
        var list = (1..20).toList()
        println(list)
//        list = list.filter { it % 3 == 0 }
        list = list.filter { it > 8 }
        println(list)
    }
}