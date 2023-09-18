package com.jgeun.feature.component.navigation_deeplink

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jgeun.feature.component.navigation_deeplink.databinding.FragmentSecondNavigationBinding

class SecondNavigationFragment : Fragment() {

	private var _binding: FragmentSecondNavigationBinding? = null
	private val binding get() = _binding!!

	override fun onAttach(context: Context) {
		super.onAttach(context)

		Log.e("Test@@@", "SecondNavigationFragment Attach")
	}

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentSecondNavigationBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		Log.e("Test@@@", "SecondNavigationFragment")
	}

	override fun onDestroyView() {
		_binding = null
		super.onDestroyView()
	}
}