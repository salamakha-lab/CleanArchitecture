package net.vsalamakha.usecases

import net.vsalamakha.data.LocationsRepository
import net.vsalamakha.domain.Location

class RequestNewLocation(private val locationsRepository: LocationsRepository) {

    operator fun invoke(): List<Location> = locationsRepository.requestNewLocation()

}