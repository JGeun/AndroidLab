package com.jgeun.core.common_ui.navigation

import android.content.Context
import com.jgeun.core.common_ui.R

sealed class DeepLinkDestination(val addressRes: Int) {

	object Serialization {
		object Gson : DeepLinkDestination(R.string.serialization_gson_deeplink_url)
	}

	object Component {
		sealed class NavigationDeepLink {
			object First : DeepLinkDestination(R.string.component_navigation_deeplink_first_screen_url)
			object Second : DeepLinkDestination(R.string.component_navigation_deeplink_second_screen_url)
		}
	}

	object Home : DeepLinkDestination(R.string.home_deeplink_url)
}

fun DeepLinkDestination.getDeepLink(context: Context) = context.getString(this.addressRes)