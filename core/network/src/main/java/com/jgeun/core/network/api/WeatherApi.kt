package com.jgeun.core.network.api

import com.jgeun.core.network.BuildConfig
import com.jgeun.core.network.model.WeatherInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
	@GET("data/2.5/weather")
	suspend fun fetchCurrentWeatherData(
		@Query("lat") lat: Float,
		@Query("lon") lon: Float,
		@Query("appid") appId: String = BuildConfig.WEATHER_API_KEY
	): Response<WeatherInfo>
}