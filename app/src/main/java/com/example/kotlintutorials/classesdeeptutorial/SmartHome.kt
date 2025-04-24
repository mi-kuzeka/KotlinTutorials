package com.example.kotlintutorials.classesdeeptutorial

internal class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {
    var deviceTurnOnCount = 0
        private set

    fun turnOnTv() {
        if (smartTvDevice.isOn()) return

        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }

    fun turnOffTv() {
        smartTvDevice.doActionIfOn({
            deviceTurnOnCount--
            smartTvDevice.turnOff()
        })
    }

    fun increaseTvVolume() {
        smartTvDevice.doActionIfOn({
            smartTvDevice.increaseSpeakerVolume()
        })
    }

    fun decreaseTvVolume() {
        smartTvDevice.doActionIfOn({
            smartTvDevice.decreaseSpeakerVolume()
        })
    }

    fun changeTvChannelToNext() {
        smartTvDevice.doActionIfOn({
            smartTvDevice.nextChannel()
        })
    }

    fun changeTvChannelToPrevious() {
        smartTvDevice.doActionIfOn({
            smartTvDevice.previousChannel()
        })
    }

    fun turnOnLight() {
        if (smartLightDevice.isOn()) return

        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }

    fun turnOffLight() {
        smartLightDevice.doActionIfOn({
            deviceTurnOnCount--
            smartLightDevice.turnOff()
        })
    }

    fun increaseLightBrightness() {
        smartLightDevice.doActionIfOn({
            smartLightDevice.increaseBrightness()
        })
    }

    fun decreaseLightBrightness() {
        smartLightDevice.doActionIfOn({
            smartLightDevice.decreaseBrightness()
        })
    }

    fun turnOffAllDevices() {
        smartTvDevice.doActionIfOn({
            smartTvDevice.turnOff()
            deviceTurnOnCount--
        })
        smartLightDevice.doActionIfOn({
            smartLightDevice.turnOff()
            deviceTurnOnCount--
        })
    }

    fun printSmartTvInfo() {
        smartTvDevice.printDeviceInfo()
    }

    fun printSmartLightInfo() {
        smartLightDevice.printDeviceInfo()
    }

    private fun SmartDevice.doActionIfOn(action: () -> Unit) {
        if (this.isOn()) {
            action()
        } else {
            println("Please turn on the device")
        }
    }
}