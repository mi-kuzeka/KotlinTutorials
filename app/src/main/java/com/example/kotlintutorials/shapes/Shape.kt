package com.example.kotlintutorials.shapes

import com.example.kotlintutorials.Utils.roundTo

abstract class Shape(
    var name: String
) {
    constructor(name: String, vararg dimensions: Double) : this(name)
    constructor(name: String, vararg dimensions: Int) : this(name)

    fun changeName(newName: String) {
        name = newName
        println("The shape name was changed to $newName")
    }

    fun printData() {
        println("The $name area is ${area().roundTo(3)}")
        println("The $name perimeter is ${perimeter().roundTo(3)}")
    }

    abstract fun area(): Double
    abstract fun perimeter(): Double
}