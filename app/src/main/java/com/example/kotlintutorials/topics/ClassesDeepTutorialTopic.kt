package com.example.kotlintutorials.topics

import com.example.kotlintutorials.classesdeeptutorial.SmartDevice
import com.example.kotlintutorials.classesdeeptutorial.SmartHome
import com.example.kotlintutorials.classesdeeptutorial.SmartLightDevice
import com.example.kotlintutorials.classesdeeptutorial.SmartTvDevice

object ClassesDeepTutorialTopic {

    fun classesDeepTutorialExample() {
        var smartDevice: SmartDevice = SmartTvDevice(
            deviceName = "Android TV",
            deviceCategory = "Entertainment"
        )
        println("Device name is ${smartDevice.name}")
        smartDevice.turnOn()
        smartDevice.turnOff()

        smartDevice = SmartLightDevice(
            "Google Light",
            "Utility"
        )
        smartDevice.turnOn()
        smartDevice.turnOff()

        println()
        println("-------CREATING SMART HOME-------")
        val smartTvDevice =
            SmartTvDevice(
                deviceName = "Android TV",
                deviceCategory = "Entertainment"
            )
        val smartLightDevice =
            SmartLightDevice(
                deviceName = "Google Light",
                deviceCategory = "Utility"
            )
        val smartHome = SmartHome(
            smartTvDevice = smartTvDevice,
            smartLightDevice = smartLightDevice
        )
        smartHome.changeTvChannelToNext()
        println()

        smartHome.turnOnTv()
        println()

        smartHome.changeTvChannelToNext()
        smartHome.changeTvChannelToPrevious()
        smartHome.changeTvChannelToPrevious()
        println()

        smartHome.increaseTvVolume()
        smartHome.increaseTvVolume()
        smartHome.increaseTvVolume()
        smartHome.decreaseTvVolume()
        println()

        smartHome.printSmartTvInfo()
        smartHome.printSmartLightInfo()
        println()

        smartHome.increaseLightBrightness()
        println()

        smartHome.turnOnLight()
        println()

        smartHome.decreaseLightBrightness()
        smartHome.increaseLightBrightness()
        println()

        smartHome.printSmartTvInfo()
        smartHome.printSmartLightInfo()
        println()

        smartHome.turnOffAllDevices()
        println()

        smartHome.printSmartTvInfo()
        smartHome.printSmartLightInfo()
        println()
    }
}