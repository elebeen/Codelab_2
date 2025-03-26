fun main() {
    val smartTv = SmartTvDevice("Android TV", "Entertainment")
    val smartLight = SmartLightDevice("Google Light", "Utility")
    val smartHome = SmartHome(smartTv, smartLight)

    smartHome.printSmartTvInfo()
    smartHome.printSmartLightInfo()
    println("")

    smartHome.turnOnTv()
    smartHome.increaseTvVolume()
    smartHome.decreaseTvVolume()
    smartHome.changeTvChannelToNext()
    smartHome.changeTvChannelToPrevious()
    println("")

    smartHome.turnOnLight()
    smartHome.increaseLightBrightness()
    smartHome.decreaseLightBrightness()
    println("")

    println("Dispositivos encendidos: ${smartHome.deviceTurnOnCount}")
    println("")

    smartHome.turnOffAllDevices()
    println("Dispositivos encendidos después de apagar todo: ${smartHome.deviceTurnOnCount}")
}