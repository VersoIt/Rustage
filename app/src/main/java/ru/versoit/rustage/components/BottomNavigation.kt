package ru.versoit.rustage.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.ImmutableList
import ru.versoit.rustage.ui.theme.Beige
import ru.versoit.rustage.ui.theme.Gray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigation(
    navigationItems: ImmutableList<NavigationItem>,
    onItemClick: (NavigationItem) -> Unit = { }
) {
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    NavigationBar(containerColor = Color.Transparent) {
        navigationItems.forEachIndexed { index, item ->
            NavigationBarItem(selected = index == selectedItemIndex, onClick = {
                if (selectedItemIndex != index) {
                    selectedItemIndex = index
                    onItemClick(item)
                }
            }, icon = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    BadgedBox(badge = {
                        if (item.badgeCount != null) {
                            Badge {
                                Text(text = item.badgeCount.toString())
                            }
                        } else if (item.hasMessage) {
                            Badge()
                        }
                    }) {
                        Icon(
                            modifier = Modifier.size(32.dp),
                            painter = item.icon,
                            contentDescription = item.destination.name,
                            tint = if (index == selectedItemIndex) Beige else Gray
                        )
                    }
                }
            })
        }
    }
}