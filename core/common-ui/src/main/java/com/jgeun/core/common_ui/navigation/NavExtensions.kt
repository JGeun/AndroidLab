package com.jgeun.core.common_ui.navigation

import android.content.Context
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavOptions

fun NavController.deepLinkNavigateTo(
	context: Context,
	deepLinkDestination: DeepLinkDestination,
	popUpTo: Boolean = false
) {
	val builder = NavOptions.Builder()

	if (popUpTo) {
		builder.setPopUpTo(graph.startDestinationId, true)
	}

	navigate(
		buildDeppLink(context, deepLinkDestination),
		builder.build()
	)
}

private fun buildDeppLink(context: Context, destination: DeepLinkDestination) =
	NavDeepLinkRequest.Builder
		.fromUri(destination.getDeepLink(context).toUri())
		.build()