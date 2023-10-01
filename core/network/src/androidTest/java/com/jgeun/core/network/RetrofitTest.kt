package com.jgeun.core.network

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jgeun.core.network.api.WeatherApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@RunWith(AndroidJUnit4::class)
class RetrofitTest {

	private lateinit var server: MockWebServer
	private lateinit var weatherApi: WeatherApi
	private lateinit var retrofit: Retrofit

	@Before
	fun setUp() {
		server = MockWebServer()
		server.start()

		retrofit = Retrofit.Builder()
			.baseUrl(server.url("https://api.openweathermap.org/"))
			.addConverterFactory(GsonConverterFactory.create())
			.build()

		weatherApi = retrofit.create(WeatherApi::class.java)
	}

	@After
	fun tearDown() {
		server.shutdown()
	}

	@Test
	fun fetchCurrentWeatherDataTest() = runTest {
		val weather = weatherApi.fetchCurrentWeatherData(
			lat = 44.34f,
			lon = 10.99f
		)

		assertNotNull(weather)
		println(weather.toString())
	}
}