package net.vsalamakha.cleanarchitecture.framework

import net.vsalamakha.data.LocationPersistenceSource
import net.vsalamakha.domain.Location

class InMemoryLocationPersistenceSource : LocationPersistenceSource {

    private var locations: List<Location> = emptyList()

    override fun getPersistedLocations(): List<Location> = locations

    override fun saveNewLocation(location: Location) {
        locations = locations + location
    }
}