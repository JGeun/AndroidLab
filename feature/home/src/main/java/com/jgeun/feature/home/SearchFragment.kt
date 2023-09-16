package com.jgeun.feature.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jgeun.feature.home.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

	private var _binding: FragmentSearchBinding? = null
	val binding get() = _binding!!

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentSearchBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		Log.e("Test@@@", "OnCreateView - SearchFragment")
	}

	override fun onDestroyView() {
		_binding = null
		super.onDestroyView()
	}
}