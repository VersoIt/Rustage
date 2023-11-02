package ru.versoit.rustage.components

import androidx.compose.foundation.layout.Column
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
import kotlinx.collections.immutable.ImmutableList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigation(
    navigationItems: ImmutableList<NavigationItem>,
    onItemClick: (Destination) -> Unit = { }
) {
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    NavigationBar {
        navigationItems.forEachIndexed { index, item ->
            NavigationBarItem(selected = true, onClick = {
                selectedItemIndex = index
                onItemClick(item.destination)
            }, icon = {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
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
                            imageVector = if (index == selectedItemIndex) item.selectedIcon else item.unselectedIcon,
                            contentDescription = item.destination.name
                        )
                    }
                    Text(text = item.name)
                }
            })
        }
    }
}