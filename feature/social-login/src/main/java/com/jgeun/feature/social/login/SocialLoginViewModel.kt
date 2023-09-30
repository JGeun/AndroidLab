package com.jgeun.feature.social.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SocialLoginViewModel : ViewModel() {

	private val _socialLoginUiState = MutableStateFlow<SocialLoginUiState>(SocialLoginUiState.IDle)
	val socialLoginUiState = _socialLoginUiState.asStateFlow()

	fun kakaoLogin() {
		_socialLoginUiState.value = SocialLoginUiState.KakaoLogin
	}

	fun kakaoLoginSuccess() {
		_socialLoginUiState.tryEmit(SocialLoginUiState.LoginSuccess)
	}

	fun kakaoLoginFail() {
		_socialLoginUiState.tryEmit(SocialLoginUiState.LoginFail)
	}

	fun setUiStateIdle() {
		_socialLoginUiState.tryEmit(SocialLoginUiState.IDle)
	}
}