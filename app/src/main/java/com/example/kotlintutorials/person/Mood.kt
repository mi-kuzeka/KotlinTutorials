package com.example.kotlintutorials.person

enum class Mood(private val formattedString: String) {
    NERVOUS("Nervous"),
    IRRITATED("Irritated"),
    DISSATISFIED("Dissatisfied"),
    NORMAL("Normal"),
    SATISFIED("Satisfied"),
    HAPPY("Happy"),
    EXCITED("Excited");

    override fun toString(): String {
        return formattedString
    }}