package net.vsalamakha.cleanarchitecture.framework

import net.vsalamakha.data.DeviceLocationSource
import net.vsalamakha.domain.Location
import java.util.*

class FakeLocationSource : DeviceLocationSource {

    private val random = Random(System.currentTimeMillis())

    override fun getDeviceLocation(): Location =
        Location(random.nextDouble() * 180 - 90, random.nextDouble() * 360 - 180, Date())
}