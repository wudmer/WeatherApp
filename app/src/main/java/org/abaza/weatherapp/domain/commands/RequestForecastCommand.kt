package org.abaza.weatherapp.domain.commands

import org.abaza.weatherapp.data.ForecastRequest
import org.abaza.weatherapp.domain.mappers.ForecastDataMapper
import org.abaza.weatherapp.domain.model.ForecastList

class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}