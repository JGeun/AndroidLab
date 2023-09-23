package com.jgeun.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import com.jgeun.feature.home.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

	private var _binding: FragmentHomeBinding? = null
	val binding get() = _binding!!

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentHomeBinding.inflate(inflater, container, false)
		binding.homeComposeView.apply {
			setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
			setContent {
				// In Compose world
				MaterialTheme {
					Text("Hello Compose!")
				}
			}
		}
		return binding.root
	}

	override fun onDestroyView() {
		_binding = null
		super.onDestroyView()
	}
}