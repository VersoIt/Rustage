package ru.versoit.rustage.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.collections.immutable.ImmutableList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navigationItems: ImmutableList<NavigationItem>) {

    val navController = rememberNavController()
    Scaffold(
        topBar = {

        },
        content = { padding ->
            NavHost(navController = navController, startDestination = Destination.HOME.name) {
                composable(route = Destination.HOME.name) {
                    Box(modifier = Modifier.padding(padding)) {
                        Text("home")
                    }
                }
                composable(route = Destination.DAMAGE_CALCULATOR.name) {
                    Box(modifier = Modifier.padding(padding)) {
                        Text("calculator")
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
                navigationItems,
                onItemClick = { selected ->
                    navController.navigate(selected.name)
                }
            )
        }
    )
}