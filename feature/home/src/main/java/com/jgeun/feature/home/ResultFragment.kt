package com.jgeun.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jgeun.feature.home.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

	private var _binding: FragmentResultBinding? = null
	val binding get() = _binding!!


	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentResultBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

	}

	override fun onDestroyView() {
		_binding = null
		super.onDestroyView()
	}
}