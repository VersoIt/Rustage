package ru.versoit.rustage.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import ru.versoit.rustage.ui.theme.Beige
import ru.versoit.rustage.ui.theme.Gray

@Composable
fun MenuNavigationDrawer(
    navigationItems: ImmutableList<NavigationItem>,
    selectedIndex: Int = 0,
    scope: CoroutineScope,
    drawerState: DrawerState,
    onItemClick: (NavigationItem) -> Unit = { },
    content: @Composable () -> Unit = {}
) {
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(selectedIndex)
    }

    ModalNavigationDrawer(drawerState = drawerState, drawerContent = {
        ModalDrawerSheet {
            navigationItems.forEachIndexed { index, item ->
                Spacer(modifier = Modifier.height(16.dp))
                NavigationDrawerItem(
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                    label = { Text(text = item.name) },
                    selected = index == selectedItemIndex,
                    onClick = {
                        scope.launch {
                            drawerState.close()
                        }
                        onItemClick(item)
                        selectedItemIndex = index
                    },
                    icon = {
                        Icon(
                            modifier = Modifier.size(32.dp),
                            painter = item.icon,
                            contentDescription = item.destination.name,
                            tint = if (index == selectedItemIndex) Beige else Gray
                        )
                    },
                    badge = {
                        if (item.badgeCount != null) {
                            Text(text = item.badgeCount.toString())
                        }
                    }
                )
            }
        }
    }) {
        content()
    }
}