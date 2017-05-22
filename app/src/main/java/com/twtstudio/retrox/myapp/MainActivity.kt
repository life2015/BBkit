package com.twtstudio.retrox.myapp

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.gson.Gson
import com.twtstudio.retrox.myapp.model.CitySearchBean
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.lang.StringBuilder
import java.net.URL

class MainActivity : AppCompatActivity() {

    val editQuery by lazy { findViewById(R.id.edit_city) as EditText }
    val searchResult by lazy { findViewById(R.id.text_search_result) as TextView }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById(R.id.search_button) as Button

        button.setOnClickListener {

            val cityName = editQuery.text.toString()

            doAsync {
                val Searchjson = URL("https://api.heweather.com/v5/search?city=$cityName&key=95c51eb8f9684df7a2f731d3bece621d").readText()
                Log.d("test",Searchjson)
                val bean = Gson().fromJson(Searchjson, CitySearchBean::class.java)
                uiThread {
                    val builder = StringBuilder()
                    bean.HeWeather5.forEach {
                        builder.append("city: ${it.basic.city}  prov: ${it.basic.prov}  status: ${it.status} \n")
                    }
                    searchResult.text = builder.toString()
                }
            }
        }

    }


}
