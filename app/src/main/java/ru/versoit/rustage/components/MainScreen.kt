package ru.versoit.rustage.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.launch

@Composable
fun MainScreen(
    bottomNavigationItems: ImmutableList<NavigationItem>,
    navigationDrawerItems: ImmutableList<NavigationItem>,
) {
    val startDestination by rememberSaveable {
        mutableStateOf(Destination.HOME.name)
    }
    var selectedScreen by rememberSaveable {
        mutableStateOf(startDestination)
    }
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    MenuNavigationDrawer(
        navigationItems = navigationDrawerItems,
        drawerState = drawerState,
        scope = scope,
        onItemClick = {
            item ->
            navController.navigate(item.destination.name)
            selectedScreen = item.name
        }
    ) {
        Scaffold(
            topBar = {
                Toolbar(label = selectedScreen, onDrawerButtonClick = {
                    scope.launch {
                        drawerState.apply {
                            if (isClosed) open() else close()
                        }
                    }
                })
            },
            content = { padding ->
                NavHost(navController = navController, startDestination = startDestination) {
                    composable(route = Destination.HOME.name) {
                        Box(modifier = Modifier.padding(padding)) {
                            Text("home")
                        }
                    }
                    composable(route = Destination.DAMAGE_CALCULATOR.name) {
                        Box(modifier = Modifier.padding(padding)) {
                            Text(text = "calculator")
                        }
                    }
                    composable(route = Destination.BINDS.name) {
                        Box(modifier = Modifier.padding(padding)) {
                            Text("binds")
                        }
                    }
                }
            },
            bottomBar = {
                BottomNavigation(
                    bottomNavigationItems,
                    onItemClick = { selected ->
                        navController.navigate(selected.destination.name)
                        selectedScreen = selected.name.uppercase()
                    },
                )
            }
        )
    }
}
