package ru.versoit.presentation.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import ru.versoit.presentation.adapters.SelectionAdapter

@Composable
fun SelectionButton(item: SelectionAdapter, onClick: () -> Unit = { }) {
    Button(onClick = onClick) {
        Row {
            Icon(imageVector = Icons.Default.KeyboardArrowUp, contentDescription = item.name)
            Text(text = item.name)
        }
    }
}