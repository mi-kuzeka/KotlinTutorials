package com.example.kotlintutorials.person

class Pus(override val mood: Mood,
               override val cupsOfCoffee: Int ):
    Person("Pus", Sex.MALE, mood, cupsOfCoffee)