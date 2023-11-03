package ru.versoit.presentation.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import ru.versoit.presentation.R
import ru.versoit.presentation.adapters.SelectionAdapter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetSelection(
    isOpen: Boolean = false,
    onDismissRequest: () -> Unit = { },
    items: ImmutableList<SelectionAdapter> = persistentListOf(),
    selectedIndex: Int? = null
) {
    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)
    if (isOpen) {
        ModalBottomSheet(
            onDismissRequest = onDismissRequest,
            windowInsets = BottomSheetDefaults.windowInsets,
            sheetState = bottomSheetState
        ) {
            Box {
                SheetItems(items = items, selectedIndex = selectedIndex)
            }
        }
    }
}

@Composable
private fun SheetItems(items: ImmutableList<SelectionAdapter>, selectedIndex: Int? = null) {
    LazyColumn {
        if (items.size < 2) {
            item {
                SheetItem(
                    label = items.first().name,
                    isSelected = if (selectedIndex != null)
                        selectedIndex == 0 else false
                )
            }
            item {
                Spacer(modifier = Modifier.height(44.dp))
            }
        } else {
            itemsIndexed(items) { index, item ->
                SheetItem(
                    label = item.name,
                    isSelected = if (selectedIndex != null)
                        selectedIndex == index else false
                )
            }
        }
    }
}

@Composable
private fun SheetItem(
    //image: Painter,
    label: String,
    onClick: () -> Unit = { },
    isSelected: Boolean = false
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }
            .padding(16.dp)
    ) {
        Text(
            text = label,
            modifier = Modifier.weight(1f),
            fontSize = 19.sp,
            lineHeight = 22.sp,
        )
        if (isSelected) {
            Icon(
                modifier = Modifier.size(21.dp),
                imageVector = Icons.Default.Check,
                contentDescription = stringResource(R.string.selected),
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}