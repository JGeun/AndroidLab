package com.jgeun.feature.home

import androidx.lifecycle.ViewModel
import com.jgeun.core.domain.usecase.GetAndroidKeywordUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SearchViewModel : ViewModel() {

	private val _androidKeywordFlow = MutableStateFlow<List<String>>(emptyList())
	val androidKeywordFlow = _androidKeywordFlow.asStateFlow()

	fun getAndroidKeyword() {
		_androidKeywordFlow.value = GetAndroidKeywordUseCase().invoke()
	}
}