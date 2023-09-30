package com.jgeun.feature.social.login

sealed interface SocialLoginUiState {
	object LoginSuccess : SocialLoginUiState
	object LoginFail : SocialLoginUiState
	object IDle : SocialLoginUiState
	object KakaoLogin : SocialLoginUiState
}