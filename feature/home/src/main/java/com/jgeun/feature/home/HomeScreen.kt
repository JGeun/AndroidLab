package com.jgeun.feature.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jgeun.core.common_ui.R.drawable.ic_search_black
import com.jgeun.core.common_ui.compose.ui.theme.HomeBgColor

@Composable
fun HomeScreen() {

	val viewModel = viewModel<SearchViewModel>()

	val androidKeywordList by viewModel.androidKeywordFlow.collectAsStateWithLifecycle()
	var searchText by remember { mutableStateOf("") }

	LaunchedEffect(searchText) {
		viewModel.getAndroidKeyword()
	}

	Column(
		modifier = Modifier
			.background(color = HomeBgColor)
			.fillMaxSize()
			.padding(vertical = 20.dp, horizontal = 24.dp)) {

		SearchBox(
			searchText = searchText,
			searchTextChange = { searchText = it }
		)

		SearchResultBox(androidKeywordList = androidKeywordList)
	}
}

@Composable
fun SearchResultBox(
	androidKeywordList: List<String>
) {
		LazyColumn(
			modifier = Modifier.fillMaxSize(),
			contentPadding = PaddingValues(vertical = 12.dp),
		) {
			itemsIndexed(androidKeywordList) { index, keyword ->
				if (index != 0) {
					Spacer(modifier = Modifier.height(20.dp))
				}

				Text(
					modifier = Modifier.background(color = Color.White, shape = RoundedCornerShape(8.dp))
						.padding(vertical = 12.dp, horizontal = 8.dp)
						.fillMaxWidth(),
					text = keyword,
					fontSize = 20.sp,
					fontWeight = FontWeight.W400
				)
			}
		}
}

@Composable
private fun SearchBox(
	searchText: String,
	searchTextChange: (String) -> Unit
) {
	Box(
		modifier = Modifier.fillMaxWidth(),
	) {
		TextField(
			value = searchText,
			onValueChange = searchTextChange,
			modifier = Modifier.fillMaxWidth(),
			leadingIcon = {
				Image(painter = painterResource(id = ic_search_black), contentDescription = "search_icon")
			},
			colors = TextFieldDefaults.textFieldColors(
				textColor = Color.Black,
				disabledTextColor = Color.Transparent,
				backgroundColor = Color.White,
				focusedIndicatorColor = Color.Transparent,
				unfocusedIndicatorColor = Color.Transparent,
				disabledIndicatorColor = Color.Transparent),
		)
	}
}