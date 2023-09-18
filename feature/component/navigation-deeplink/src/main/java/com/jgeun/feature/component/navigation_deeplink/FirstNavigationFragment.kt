package com.jgeun.feature.component.navigation_deeplink

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jgeun.core.common_ui.navigation.DeepLinkDestination
import com.jgeun.core.common_ui.navigation.deepLinkNavigateTo
import com.jgeun.feature.component.navigation_deeplink.databinding.FragmentFirstNavigationBinding

class FirstNavigationFragment : Fragment() {

	private var _binding: FragmentFirstNavigationBinding? = null
	private val binding get() = _binding!!

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentFirstNavigationBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		binding.btnDeeplinkFirstToSecond.setOnClickListener {
			findNavController().deepLinkNavigateTo(requireContext(), DeepLinkDestination.Component.NavigationDeepLink.Second)
		}
	}

	override fun onDestroyView() {
		_binding = null
		super.onDestroyView()
	}
}