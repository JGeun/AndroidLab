package com.jgeun.feature.social.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.jgeun.feature.social.login.databinding.FragmentSocialLoginBinding
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient
import kotlinx.coroutines.launch

class SocialLoginFragment : Fragment() {

	private val TAG = SocialLoginFragment::class.java.simpleName
	private var _binding: FragmentSocialLoginBinding? = null
	private val binding get() = _binding!!

	private val viewModel by viewModels<SocialLoginViewModel>()

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
		_binding = FragmentSocialLoginBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		binding.kakaoLogin.setOnClickListener {
			viewModel.kakaoLogin()
		}

		viewLifecycleOwner.lifecycleScope.launch {
			repeatOnLifecycle(Lifecycle.State.STARTED) {
				viewModel.socialLoginUiState.collect { uiState ->
					when (uiState) {
						SocialLoginUiState.KakaoLogin -> {
							handleKakaoLogin()
						}
						SocialLoginUiState.LoginSuccess -> {
							showToast("Login Success")
						}
						SocialLoginUiState.LoginFail -> {
							showToast("Login Fail")
						}
						else -> {}
					}
				}
			}
		}
	}

	private fun handleKakaoLogin() {

		// 카카오계정으로 로그인 공통 callback 구성
		// 카카오톡으로 로그인 할 수 없어 카카오계정으로 로그인할 경우 사용됨
		val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
			if (error != null) {
				Log.e(TAG, "카카오계정으로 로그인 실패", error)
				viewModel.kakaoLoginFail()
			} else if (token != null) {
				Log.i(TAG, "카카오계정으로 로그인 성공 ${token.accessToken}")
				viewModel.kakaoLoginSuccess()
			}
		}

		if (UserApiClient.instance.isKakaoTalkLoginAvailable(requireContext())) {
			UserApiClient.instance.loginWithKakaoTalk(requireContext()) { token, error ->
				if (error != null) {
					Log.e(TAG, "카카오톡으로 로그인 실패", error)

					// 사용자가 카카오톡 설치 후 디바이스 권한 요청 화면에서 로그인을 취소한 경우,
					// 의도적인 로그인 취소로 보고 카카오계정으로 로그인 시도 없이 로그인 취소로 처리 (예: 뒤로 가기)
					if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
						return@loginWithKakaoTalk
					}

					// 카카오톡에 연결된 카카오계정이 없는 경우, 카카오계정으로 로그인 시도
					UserApiClient.instance.loginWithKakaoAccount(requireContext(), callback = callback)
				} else if (token != null) {
					Log.i(TAG, "카카오톡으로 로그인 성공 ${token.accessToken}")
					viewModel.kakaoLoginSuccess()
				}
			}
		} else {
			UserApiClient.instance.loginWithKakaoAccount(requireContext(), callback = callback)
		}
	}

	private fun showToast(message: String) {
		Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
		viewModel.setUiStateIdle()
	}

	override fun onDestroyView() {
		_binding = null
		super.onDestroyView()
	}
}