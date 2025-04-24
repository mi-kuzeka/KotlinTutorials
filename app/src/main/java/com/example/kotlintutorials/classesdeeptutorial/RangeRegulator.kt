package com.example.kotlintutorials.classesdeeptutorial

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

internal class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        fieldData = when {
            value < minValue -> minValue
            value > maxValue -> maxValue
            else -> value
        }
    }
}