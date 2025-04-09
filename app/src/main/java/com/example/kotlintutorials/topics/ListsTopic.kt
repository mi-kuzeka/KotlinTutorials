package com.example.kotlintutorials.topics

import com.example.kotlintutorials.Utils

object ListsTopic {
    fun fibonacciList() {
        println("Enter the count of Fibonacci numbers")
        val fibonacciCount = Utils.readInt(
            true,
            "Please enter a positive integer number"
        )
        val fibonacciList = mutableListOf(0L)
        var nextValue = 1L
        var countAdded = 1
        while (countAdded < fibonacciCount) {
            fibonacciList.add(nextValue)
            nextValue += fibonacciList[countAdded - 1]
            countAdded++
        }
        println(fibonacciList)
    }

    fun reversedList() {
        val list = mutableListOf<Int>()
        for (i in 1..10) {
            val x = readLine()?.toInt()
            if (x != null)
                list.add(x)
        }

        println(list.asReversed())
    }

    fun addingAndRemovingFromList() {
        val list = mutableListOf(4, 5, 7, 1, 5, 2, 3)
        list.add(8)
        list.remove(5)
        list.removeAt(2)
        println(list.toString())
    }

    fun averageValueOfList() {
        val myArray = Array(5) { 0 }
        println("Enter 5 integer numbers")
        for (i in 0..4) {
            try {
                myArray[i] = readln().toInt()
            } catch (e: TypeCastException) {
                continue
            }
        }
        println("The average value is: ${myArray.sum() / myArray.size.toFloat()}")
    }

    fun minMaxSumOfList() {
        val myArray = arrayOf(1, 15, 3, 22, 6, -7, 7, 4, 0, 68, 4, 17, 53)
        var max = myArray[0]
        var min = max
        var sum = 0
        for (number in myArray) {
            if (number > max) max = number
            if (number < min) min = number
            sum += number
        }
        println("All numbers: ${myArray.contentToString()}")
        println("Max number is $max")
        println("Min number is $min")
        println("The sum is $sum (loop)")
        println("The sum is ${myArray.sum()}")
    }
}