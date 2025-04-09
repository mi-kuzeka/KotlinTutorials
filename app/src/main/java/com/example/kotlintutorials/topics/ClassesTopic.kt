package com.example.kotlintutorials.topics

import com.example.kotlintutorials.shapes.Circle
import com.example.kotlintutorials.shapes.Rectangle
import com.example.kotlintutorials.shapes.Shape
import com.example.kotlintutorials.shapes.Triangle
import com.example.kotlintutorials.shapes.isSquare
import com.example.kotlintutorials.shapes.printRectangle

object ClassesTopic {
    fun createTriangle() {
        val triangle: Shape = Triangle(2.0, 4.0, 5.0)
        triangle.printData()
    }

    fun createCircle() {
        val circle1 = Circle(5.5)
        val circle2 = Circle(9.0)
        val circle3 = Circle.randomCircle()
    }

    fun createRect() {
//    val rectangle = Rectangle(4, 9)
//    val rectangle = Rectangle.randomRectangle()
        val rectangle = Rectangle.randomSquare()
        rectangle.printRectangle()
        rectangle.printData()
//    rectangle.changeName("square")
//    rectangle.printData()
        println("The ${rectangle.name} is${if (rectangle.isSquare()) "" else "n't"} square")
    }
}