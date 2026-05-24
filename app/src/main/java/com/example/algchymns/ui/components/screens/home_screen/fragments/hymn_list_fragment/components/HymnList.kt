package com.example.algchymns.ui.components.screens.home_screen.fragments.hymn_list_fragment.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.algchymns.data.remote.response_models.Hymn
import com.example.algchymns.data.remote.response_models.dummyHymnList
import com.example.algchymns.ui.components.util.PreviewColumn


@Composable
fun HymnList(
    hymnItems: List<Hymn>,
    onHymnClick: (Hymn) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
        ,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Spacer(modifier = Modifier
                .height(8.dp))
        }
        itemsIndexed(hymnItems){ index, hymn ->
            HymnListItem(
                hymnNumber = index + 1,
                hymnTitle = hymn.title,
                onClick = { onHymnClick(hymn) },
            )
        }
        item {
            Spacer(modifier = Modifier
                .height(16.dp))
        }
    }
}

@Preview
@Composable
private fun HymnListPreview() {
    PreviewColumn {
        HymnList(
            hymnItems = dummyHymnList,
            onHymnClick = { _ ->

            }
        )
    }
}