package net.vsalamakha.cleanarchitecture.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import net.vsalamakha.cleanarchitecture.R
import kotlinx.android.extensions.LayoutContainer
import kotlin.properties.Delegates

class LocationsAdapter : RecyclerView.Adapter<LocationsAdapter.ViewHolder>() {

    var items: List<Location> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_location_item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        fun bind(location: Location) {
            with(location) {
                this@ViewHolder.containerView.findViewById<TextView>(R.id.locationCoordinates).text = coordinates
                this@ViewHolder.containerView.findViewById<TextView>(R.id.locationDate).text = date
            }
        }
    }
}
