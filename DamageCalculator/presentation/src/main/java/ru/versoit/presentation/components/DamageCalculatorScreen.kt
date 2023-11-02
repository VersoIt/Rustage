package ru.versoit.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import kotlinx.collections.immutable.ImmutableList
import ru.versoit.presentation.adapters.SelectionAdapter

@Composable
fun DamageCalculatorScreen(
    weapons: ImmutableList<SelectionAdapter>,
    barricades: ImmutableList<SelectionAdapter>,
    selectedWeapon: SelectionAdapter,
    selectedBarricade: SelectionAdapter,
    onWeaponSelect: (SelectionAdapter) -> Unit = {},
    onBarricadeSelect: (SelectionAdapter) -> Unit = {}
) {
    Column {
        Selection(onSelect = onWeaponSelect)
        Text("vs")
        Selection(onSelect = onBarricadeSelect)
    }
}