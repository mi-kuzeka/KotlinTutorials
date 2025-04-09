package com.example.kotlintutorials.topics

import com.example.kotlintutorials.person.Mood
import com.example.kotlintutorials.person.Pus

object NullSafetyTopic {
    fun nullSafetyExample() {
        var pus: Pus? = null
        printPusInfo(pus)
        pus = Pus(Mood.SATISFIED, 2)
        printPusInfo(pus)
    }

    fun printPusInfo(pus: Pus?) {
        println(
            "Pus is ${pus?.mood?.name?.lowercase()} and he drunk " +
                    "${pus?.cupsOfCoffee} cups of coffee today"
        )
    }
}