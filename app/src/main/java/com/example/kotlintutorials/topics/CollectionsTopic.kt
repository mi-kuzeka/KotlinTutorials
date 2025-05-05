package com.example.kotlintutorials.topics

object CollectionsTopic {
    fun mapExample() {
        val solarSystem = mutableMapOf(
            "Mercury" to 0,
            "Venus" to 0,
            "Earth" to 1,
            "Mars" to 2,
            "Jupiter" to 79,
            "Saturn" to 82,
            "Uranus" to 27,
            "Neptune" to 14
        )

        println(solarSystem.size) // 8
        solarSystem["Pluto"] = 5 // adding a new element to the map
        println(solarSystem.size) // 9
        println(solarSystem["Pluto"]) // 5
        println(solarSystem.get("Theia")) // null
        solarSystem.remove("Pluto")
        println(solarSystem.size) // 8
        solarSystem["Jupiter"] = 78
        println(solarSystem["Jupiter"]) // 78
    }

    fun setExample() {
        val solarSystem = mutableSetOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")

        println(solarSystem.size) // 8
        solarSystem.add("Pluto")
        // this element will not be added because the set contains only unique values
        solarSystem.add("Mars")
        println(solarSystem.size) // 9
        println(solarSystem.contains("Pluto")) // true
        println("Pluto" in solarSystem) // true
        solarSystem.remove("Pluto")
        println(solarSystem.size)
        println("Pluto" in solarSystem)
    }

    fun mutableListExample() {
        val solarSystem = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
        println(solarSystem.size) // 8
        solarSystem.add("Pluto")
        println(solarSystem.size) // 9
        println("----------------------")
        println(solarSystem.indexOf("Earth")) // 2
        println(solarSystem.indexOf("Pluto")) // 8
        println("----------------------")
        solarSystem.add(3, "Theia")
        println(solarSystem.indexOf("Theia")) // 3
        println("----------------------")
        solarSystem[3] = "Future Moon"
        println(solarSystem[3]) // Future Moon
        println(solarSystem[9]) // Pluto
        println("----------------------")
        solarSystem.removeAt(9)
        solarSystem.remove("Future Moon")
        println(solarSystem.contains("Pluto")) // false
        println("Future Moon" in solarSystem) // false
    }

    fun listExample() {
        val solarSystem = listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
        println(solarSystem.size) // 8
        println("----------------------")
        println(solarSystem[2]) // Earth
        println(solarSystem.get(3)) // Mars
        println(solarSystem.indexOf("Earth")) // 2
        println(solarSystem.indexOf("Pluto")) // -1
        println("----------------------")
        for (planet in solarSystem) {
            println(planet)
        }
    }

    fun arrayExample() {
        val rockPlanets = arrayOf<String>("Mercury", "Venus", "Earth", "Mars")
        val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")
        val solarSystem = rockPlanets + gasPlanets
        for (planet in solarSystem) {
            println(planet)
        }
        println("----------------------")
        solarSystem[3] = "Little Earth"
        println(solarSystem[3]) // Little Earth
    }
}