package com.example.kotlintutorials

fun Int.isPrime(): Boolean {
    for (i in 2 until this) {
        if (this % i == 0) return false
    }
    return true
}

fun List<Int>.getProduct(): Int {
    var product = 1
    for (number in this) product *= number
    return product
}