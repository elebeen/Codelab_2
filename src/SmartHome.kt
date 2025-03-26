class SmartHome(
    private val smartTvDevice: SmartTvDevice,
    private val smartLightDevice: SmartLightDevice
) {

    var deviceTurnOnCount = 0
        private set

    private fun updateTurnOnCount() {
        deviceTurnOnCount = listOf(smartTvDevice, smartLightDevice)
            .count { it.deviceStatus == "on" }
    }

    fun turnOnTv() {
        if (smartTvDevice.deviceStatus != "on") {
            smartTvDevice.turnOn()
            updateTurnOnCount()
        } else {
            println("The device must be turn off")
        }
    }

    fun turnOffTv() {
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.turnOff()
            updateTurnOnCount()
        } else {
            println("Turn on the device first")
        }
    }

    fun increaseTvVolume() {
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.increaseSpeakerVolume()
        } else {
            println("Turn on the device first")
        }
    }

    fun decreaseTvVolume() {
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.decreaseSpeakerVolume()
        } else {
            println("Turn on the device first")
        }
    }

    fun changeTvChannelToNext() {
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.nextChannel()
        } else {
            println("Turn on the device first")
        }
    }

    fun changeTvChannelToPrevious() {
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.previousChannel()
        } else {
            println("Turn on the device first")
        }
    }

    fun turnOnLight() {
        if (smartLightDevice.deviceStatus != "on") {
            deviceTurnOnCount++
            smartLightDevice.turnOn()
        } else {
            println("The device must be turn off")
        }
    }

    fun turnOffLight() {
        if (smartLightDevice.deviceStatus == "on") {
            deviceTurnOnCount--
            smartLightDevice.turnOff()
        } else {
            println("Turn on the device first")
        }
    }

    fun increaseLightBrightness() {
        if (smartLightDevice.deviceStatus == "on") {
            smartLightDevice.increaseBrightness()
        } else {
            println("Turn on the device first")
        }
    }

    fun decreaseLightBrightness() {
        if (smartLightDevice.deviceStatus == "on") {
            smartLightDevice.decreaseBrightness()
        } else {
            println("Turn on the device first")
        }
    }

    fun turnOffAllDevices() {
        var changed = false
        if (smartTvDevice.deviceStatus == "on") {
            turnOffTv()
            changed = true
        }
        if (smartLightDevice.deviceStatus == "on") {
            turnOffLight()
            changed = true
        }
        if (changed) {
            updateTurnOnCount()
        }
    }

    fun printSmartTvInfo(){
        smartTvDevice.printDeviceInfo()
    }

    fun printSmartLightInfo() {
        smartLightDevice.printDeviceInfo()
    }
}