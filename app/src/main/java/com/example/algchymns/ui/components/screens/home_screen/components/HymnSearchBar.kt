package com.example.algchymns.ui.components.screens.home_screen.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.example.algchymns.ui.components.util.CustomSearchTextField
import com.example.algchymns.ui.components.util.CustomTextFieldState
import com.example.algchymns.ui.components.util.PreviewColumn
import com.example.algchymns.ui.components.util.rememberCustomTextFieldState
import com.example.algchymns.ui.theme.colorDim
import com.example.algchymns.ui.theme.colorHoly

@Composable
fun HymnSearchBar(
    modifier: Modifier = Modifier,
    searchFieldState: CustomTextFieldState,
) {

    CustomSearchTextField(
        textFieldState = searchFieldState,
        containerColor = colorHoly,
        cursorColor = colorDim,
        leadingIconColor = colorDim,
        trailingIconColor = colorDim,
        textColor = colorDim,
        modifier = modifier
            .clip(RoundedCornerShape(50))
        ,
    )
}

@Preview
@Composable
private fun HymnSearchBarPreview() {
    PreviewColumn {
        HymnSearchBar(
            searchFieldState = rememberCustomTextFieldState(
                onQueryChange = {},
            )
        )
    }
}