package org.abaza.weatherapp.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_forecast.view.*
import org.abaza.weatherapp.R
import org.abaza.weatherapp.domain.model.Forecast
import org.abaza.weatherapp.domain.model.ForecastList
import org.abaza.weatherapp.ui.utils.ctx

class ForecastListAdapter(private val weekForecast: ForecastList,
                          val itemClick: (Forecast)-> Unit) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)
        return  ViewHolder(view, itemClick)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bindForecast(weekForecast[position])
    }

    override fun getItemCount(): Int = weekForecast.size

    class ViewHolder(view: View, val itemClick: (Forecast)-> Unit) : RecyclerView.ViewHolder(view) {

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(itemView.icon)
                itemView.date.text = date
                itemView.description.text = description
                itemView. maxTemperature.text = "${high}º"
                itemView.minTemperature.text = "${low}º"
                itemView.setOnClickListener { itemClick(this) }
            }
        }

    }
}

