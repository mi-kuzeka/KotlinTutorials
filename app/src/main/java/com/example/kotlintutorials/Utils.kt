package com.example.kotlintutorials

import java.util.Locale

object Utils {
    fun readInt(shouldBePositive: Boolean, errorMessage: String): Int {
        var enteredValue: Int? = null
        var valueIsInvalid = true
        while (valueIsInvalid) {
            enteredValue = readlnOrNull()?.toIntOrNull()
            valueIsInvalid = enteredValue == null || (shouldBePositive && enteredValue <= 0)
            if (valueIsInvalid) println(errorMessage)
        }
        return enteredValue!!
    }

    fun Float.roundTo(digitCount: Int): String =
        String.format(Locale.getDefault(), "%.${digitCount}f", this)

    fun Double.roundTo(digitCount: Int): String =
        String.format(Locale.getDefault(), "%.${digitCount}f", this)
}