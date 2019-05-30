package net.vsalamakha.usecases

import net.vsalamakha.data.LocationsRepository
import net.vsalamakha.domain.Location

class GetLocations(private val locationsRepository: LocationsRepository) {

    operator fun invoke(): List<Location> = locationsRepository.getSavedLocations()

}

