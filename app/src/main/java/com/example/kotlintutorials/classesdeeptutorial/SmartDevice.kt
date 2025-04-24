package com.example.kotlintutorials.classesdeeptutorial

internal open class SmartDevice protected constructor(val name: String, val category: String) {
    var status = "off"
        protected set

    open val deviceType = "unknown"

    constructor(name: String, category: String, statusCode: Int) : this(name, category) {
        status = when (statusCode) {
            0 -> "off"
            1 -> "on"
            else -> "unknown"
        }
    }

    open fun turnOn() {
        status = "on"
    }

    open fun turnOff() {
        status = "off"
    }

    fun isOn(): Boolean {
        return status == "on"
    }

    fun printDeviceInfo() {
        println("Device name: $name, category: $category, type: $deviceType, status: $status")
    }
}