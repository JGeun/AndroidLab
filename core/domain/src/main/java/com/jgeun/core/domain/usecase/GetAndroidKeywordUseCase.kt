package com.jgeun.core.domain.usecase

class GetAndroidKeywordUseCase {

	private val keywordList = listOf(
		"gson", "compose"
	)
	operator fun invoke() = keywordList
}