package com.example.algchymns.ui.components.screens.home_screen.components

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.algchymns.R
import com.example.algchymns.ui.components.screens.home_screen.models.HomeFragmentsState
import com.example.algchymns.ui.components.util.AppDropdownMenu
import com.example.algchymns.ui.components.util.AppIconButton
import com.example.algchymns.ui.components.util.PreviewColumn
import com.example.algchymns.ui.components.util.rememberCustomTextFieldState
import com.example.algchymns.ui.theme.colorHoly
import com.example.algchymns.ui.theme.tsOrion

@Composable
fun HomeScreenTopBar(
    modifier: Modifier = Modifier,
    homeFragmentsState: HomeFragmentsState,
    onSearchQueryChange: (String) -> Unit,
    handleSearchFocusChange: (Boolean) -> Unit,
    navBack: () -> Unit,
) {

    val searchFieldState = rememberCustomTextFieldState(
        onQueryChange = onSearchQueryChange,
    )
    val isSearchFocused by searchFieldState.isFocused.collectAsState()
    LaunchedEffect(isSearchFocused) {
        handleSearchFocusChange(isSearchFocused)
    }

    val isAwayFromHymnList = homeFragmentsState != HomeFragmentsState.HymnList


    val clearSearchBar = {
        searchFieldState.clearText(
            hideKeyboard = true
        )
        searchFieldState.onFocusChange(false)
    }

    val handleNavBack = {
        navBack()
        clearSearchBar()
    }

    BackHandler(
        enabled = isAwayFromHymnList
    ) {
        handleNavBack()
    }

    var previousFragmentsState by remember { mutableStateOf(homeFragmentsState) }
    LaunchedEffect(homeFragmentsState) {
        val isLeftHymnSearch = previousFragmentsState is HomeFragmentsState.HymnSearch
                && homeFragmentsState !is HomeFragmentsState.HymnSearch
        if (isLeftHymnSearch) {
            clearSearchBar()
        }
        previousFragmentsState = homeFragmentsState
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp)
            .padding(
                start = 16.dp,
                end = 8.dp,
            )
    ) {
        AnimatedVisibility(
            visible = isAwayFromHymnList,
        ) {
            AppIconButton(
                iconRes = R.drawable.ic_left_chevron,
                color = colorHoly,
                onClick = handleNavBack,
            )
        }
        if (homeFragmentsState is HomeFragmentsState.HymnLyrics) {
            val hymn = homeFragmentsState.hymn
            Text(
                text = hymn.title,
                style = tsOrion
                    .copy(
                        fontWeight = FontWeight.Bold
                    )
            )

        } else {
            HymnSearchBar(
                searchFieldState = searchFieldState,
                modifier = Modifier
                    .weight(1f)
            )
            AppDropdownMenu(
                dropdownOptions = emptyList()
            )
        }
    }
}

@Preview
@Composable
private fun HomeScreenTopBarPreview() {
    val homeFragmentsState = HomeFragmentsState.HymnList
    PreviewColumn {
        HomeScreenTopBar(
            homeFragmentsState = homeFragmentsState,
            onSearchQueryChange = { _ -> },
            navBack = {},
            handleSearchFocusChange = {},
        )
    }
}