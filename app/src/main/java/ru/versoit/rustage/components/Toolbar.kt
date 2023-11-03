package ru.versoit.rustage.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.versoit.rustage.R

@Preview
@Composable
fun Toolbar(label: String = "") {

    val colors = MaterialTheme.colorScheme
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(colors.surfaceVariant)
            .padding(horizontal = 10.dp),
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ToolbarButton(
                painter = painterResource(id = R.drawable.menu),
                contentDescription = stringResource(
                    id = R.string.menu
                ),
                onClick = {

                }
            )
            Text(text = label, fontSize = 16.sp)
            ToolbarButton(
                painter = painterResource(id = R.drawable.youtube),
                contentDescription = stringResource(
                    id = R.string.youtube
                ),
                onClick = {

                }
            )
        }
    }
}

@Composable
private fun ToolbarButton(painter: Painter, contentDescription: String, onClick: () -> Unit = { }) {
    val colors = MaterialTheme.colorScheme
    IconButton(
        onClick = onClick,
        colors = IconButtonDefaults.iconButtonColors(containerColor = Color.Transparent)
    ) {
        Icon(
            painter = painter,
            contentDescription = contentDescription,
            modifier = Modifier.size(24.dp),
            tint = colors.onSurface
        )
    }
}