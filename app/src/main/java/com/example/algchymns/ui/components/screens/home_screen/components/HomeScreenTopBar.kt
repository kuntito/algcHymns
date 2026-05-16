package com.example.algchymns.ui.components.screens.home_screen.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.algchymns.R
import com.example.algchymns.ui.components.util.AppDropdownMenu
import com.example.algchymns.ui.components.util.AppIconButton
import com.example.algchymns.ui.components.util.CustomTextFieldState
import com.example.algchymns.ui.components.util.PreviewColumn
import com.example.algchymns.ui.components.util.rememberCustomTextFieldState
import com.example.algchymns.ui.theme.colorHoly

@Composable
fun HomeScreenTopBar(
    modifier: Modifier = Modifier,
    searchFieldState: CustomTextFieldState,
    navFromSearchFragment: () -> Unit,
) {


    val isSearchFocused by searchFieldState.isFocused.collectAsState()
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
            visible = isSearchFocused,
        ) {
            AppIconButton(
                iconRes = R.drawable.ic_left_chevron,
                color = colorHoly,
                onClick = navFromSearchFragment,
            )
        }
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

@Preview
@Composable
private fun HomeScreenTopBarPreview() {
    PreviewColumn {
        HomeScreenTopBar(
            searchFieldState = rememberCustomTextFieldState(
                onQueryChange = {},
            ),
            navFromSearchFragment = {},
        )
    }
}