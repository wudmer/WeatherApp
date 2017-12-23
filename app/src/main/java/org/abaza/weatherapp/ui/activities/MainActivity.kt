package org.abaza.weatherapp.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.abaza.weatherapp.R
import org.abaza.weatherapp.domain.commands.RequestForecastCommand
import org.abaza.weatherapp.ui.adapter.ForecastListAdapter
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        forecastlist.layoutManager = LinearLayoutManager(this)
        doAsync {
            val result = RequestForecastCommand("53000").execute()
            uiThread {

                val adapter = ForecastListAdapter(result){ toast(it.date)}
                forecastlist.adapter = adapter
            }

        }
    }
}
