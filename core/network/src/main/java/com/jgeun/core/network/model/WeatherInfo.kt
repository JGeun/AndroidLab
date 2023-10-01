package com.jgeun.core.network.model

data class WeatherInfo(
	val coord: Coord,
	val weather: List<Weather>,
	val base: String,
	val main: WeatherMain,
	val visibility: Int,
	val wind: Wind,
	val clouds: Cloud,
	val dt: Long,
	val sys: Sys,
	val timezone: Int,
	val id: Long,
	val name: String,
	val cod: Int
)

data class Coord(
	val lon: Float,
	val lat: Float
)

data class Weather(
	val id: Long,
	val main: String,
	val description: String,
	val icon: String,
)

data class WeatherMain(
	val temp: Float,
	val feels_like: Float,
	val temp_min: Float,
	val pressure: Int,
	val humidity: Int,
	val sea_level: Int,
	val grnd_level: Int
)

data class Wind(
	val speed: Float,
	val deg: Int,
	val gust: Float
)

data class Cloud(
	val all: Int,
)

data class Sys(
	val type: Int,
	val id: Long,
	val country: String,
	val sunrise: Long,
	val sunset: Long
)