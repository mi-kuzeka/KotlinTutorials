package com.example.kotlintutorials.topics

object FunctionOperatorsTopic {
    fun searchFor(search: String, searchEngine: String = "Google") {
        println("Searching for '$search' on $searchEngine")
    }

    fun getAlternatingSum(vararg numbers: Int): Int {
        var sum = 0
        var toggle = true
        for (n in numbers) {
            if (toggle) {
                sum += n
            } else {
                sum -= n
            }
            toggle = !toggle
        }
        return sum
    }

    fun getMax(vararg numbers: Int): Int {
        var max = numbers[0]
        for (n in numbers) {
            if (n > max) max = n
        }
        return max
    }
}