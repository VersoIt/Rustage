package ru.versoit.rustage.components

import androidx.compose.ui.graphics.painter.Painter

enum class Destination {
    HOME,
    DAMAGE_CALCULATOR,
    BINDS
}

data class NavigationItem(
    val destination: Destination = Destination.HOME,
    val name: String = "",
    val hasMessage: Boolean = false,
    val icon: Painter,
    val badgeCount: Int? = null,
)
