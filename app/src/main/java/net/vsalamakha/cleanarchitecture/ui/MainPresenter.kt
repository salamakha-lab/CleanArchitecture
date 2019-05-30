package net.vsalamakha.cleanarchitecture.ui

import kotlinx.coroutines.*
import net.vsalamakha.domain.Location as DomainLocation
import net.vsalamakha.usecases.GetLocations
import net.vsalamakha.usecases.RequestNewLocation
import kotlin.coroutines.CoroutineContext

class MainPresenter (
    private var view: View?,
    private val getLocations: GetLocations,
    private val requestNewLocation: RequestNewLocation
): CoroutineScope {
    private var job: Job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job


    interface View {
        fun renderLocations(locations: List<Location>)
    }

    fun onCreate() = launch{

        val locations = withContext(Dispatchers.IO) {
            getLocations()
        }
        view?.renderLocations(locations.map(DomainLocation::toPresentationModel))
    }

    fun newLocationClicked() = launch {
        val locations = withContext(Dispatchers.IO) {
            requestNewLocation()
        }
        view?.renderLocations(locations.map(DomainLocation::toPresentationModel))
    }

    fun onDestroy() {
        job.cancel()

        view = null
    }
}