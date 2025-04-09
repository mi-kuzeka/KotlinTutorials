package com.example.kotlintutorials.topics

import com.example.kotlintutorials.Pus

object NullSafetyTopic {
    fun nullSafetyExample() {
        var pus: Pus? = null
        printPusInfo(pus)
        pus = Pus("cute", 2)
        printPusInfo(pus)
    }

    fun printPusInfo(pus: Pus?) {
        println(
            "Pus is ${pus?.whatIsHeLike} and he drunk " +
                    "${pus?.cupsOfCoffeeDrunk} cups of coffee today"
        )
    }
}