package com.example.kotlintutorials.person

open class Person(
    open val name: String,
    open val sex: Sex,
    open val mood: Mood,
    open val cupsOfCoffee: Int
) {
    operator fun component1() = name
    operator fun component2() = sex
    operator fun component3() = mood
    operator fun component4() = cupsOfCoffee
}
