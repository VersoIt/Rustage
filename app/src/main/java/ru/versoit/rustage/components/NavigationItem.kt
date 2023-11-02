package ru.versoit.rustage.components

import androidx.compose.ui.graphics.vector.ImageVector

enum class Destination {
    HOME,
    DAMAGE_CALCULATOR,
    BINDS
}

data class NavigationItem(
    val destination: Destination = Destination.HOME,
    val name: String = "",
    val hasMessage: Boolean = false,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val badgeCount: Int? = null,
)
