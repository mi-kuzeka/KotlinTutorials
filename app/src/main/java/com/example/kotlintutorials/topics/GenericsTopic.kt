package com.example.kotlintutorials.topics

object GenericsTopic {
    fun genericExample() {
        val integers = (1..20).toList().customFilter { it > 10 }
            .customFilter { it % 3 == 0 }
        println(integers)
    }

    fun <T> List<T>.customFilter(filterFunction: (T) -> Boolean): List<T> {
        val resultList = mutableListOf<T>()
        for (item in this) {
            if (filterFunction(item)) resultList.add(item)
        }
        return resultList
    }
}