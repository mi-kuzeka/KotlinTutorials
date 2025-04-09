package com.example.kotlintutorials.topics

import com.example.kotlintutorials.animal.AnimalColor
import com.example.kotlintutorials.animal.Bird
import com.example.kotlintutorials.person.Mood
import com.example.kotlintutorials.person.Person
import com.example.kotlintutorials.person.Sex
import com.example.kotlintutorials.person.Pus

object DestructuringDeclarationsTopic {
    fun destructuringCollections() {
        val persons = mutableListOf<Person>()
        persons.add(Person("Jack", Sex.MALE, Mood.EXCITED, 4))
        persons.add(Person("Lin", Sex.FEMALE, Mood.IRRITATED, 5))
        persons.add(Person("Angela", Sex.FEMALE, Mood.DISSATISFIED, 0))
        persons.add(Person("John", Sex.MALE, Mood.NORMAL, 1))
        persons.add(Person("Emma", Sex.FEMALE, Mood.SATISFIED, 2))
        persons.add(Person("Oscar", Sex.MALE, Mood.NERVOUS, 6))
        persons.add(Person("Roxana", Sex.FEMALE, Mood.HAPPY, 3))
        for ((name, sex, mood, cupsCount) in persons) {
            println(
                "$name drunk $cupsCount cups of coffee and " +
                        "${if (sex.equals(Sex.FEMALE)) "she" else "he"} is ${mood.name.lowercase()}."
            )
        }
    }

    fun destructuringFunction() {
        val pus = Pus(Mood.DISSATISFIED, 0)
        println("Pus have drunk ${pus.cupsOfCoffee} cups of coffee and he is ${pus.mood.name.lowercase()}.")
        println("Let's cheer him up!")
        val (_, _, mood, cups) = pus.cheerUp()
        println("Pus have drunk $cups cups of coffee and he is ${mood.name.lowercase()}!")
    }

    fun destructuringWithDataClass() {
        val birds = mutableListOf<Bird>()
        birds.add(
            Bird(
                name = "pigeon", color = AnimalColor.BLUE,
                canSing = false, canFly = true
            )
        )
        birds.add(
            Bird(
                name = "hen", color = AnimalColor.ORANGE,
                canSing = false, canFly = false
            )
        )
        birds.add(
            Bird(
                name = "starling", color = AnimalColor.BLACK,
                canSing = true, canFly = true
            )
        )
        birds.add(
            Bird(
                name = "sparrow", color = AnimalColor.BROWN,
                canSing = true, canFly = true
            )
        )
        birds.add(
            Bird(
                name = "tit", color = AnimalColor.YELLOW,
                canSing = true, canFly = true
            )
        )
        birds.add(
            Bird(
                name = "ostrich", color = AnimalColor.BLACK,
                canSing = false, canFly = false
            )
        )
        birds.add(
            Bird(
                name = "gull", color = AnimalColor.WHITE,
                canSing = true, canFly = true
            )
        )
        birds.add(
            Bird(
                name = "duck", color = AnimalColor.COLORFUL,
                canSing = true, canFly = true
            )
        )
        val newBirds = birds.map { it.capitalizeFirstLetter() }.toMutableList()
        for ((name, color, canSing, canFly) in newBirds) {
            println("$name is ${color.name.lowercase()}, " +
                    "it ${canSing.getCanOrCantString()} sing and " +
                    "it ${canFly.getCanOrCantString()} fly")
        }
    }

    private fun Boolean.getCanOrCantString() = if (this) "can" else "can't"

    private fun Bird.capitalizeFirstLetter(): Bird =
        Bird(
            name = this.name.replaceFirstChar { it.uppercase() },
            color = this.color, canSing = this.canSing, canFly = this.canFly
        )

    private fun Pus.cheerUp(): Pus =
        Pus(Mood.HAPPY, this.cupsOfCoffee + 2)
}