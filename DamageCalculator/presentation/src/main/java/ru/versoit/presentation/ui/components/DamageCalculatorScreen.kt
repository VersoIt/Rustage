package ru.versoit.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.ImmutableList
import ru.versoit.domain.Barricade
import ru.versoit.domain.Weapon
import ru.versoit.presentation.adapters.SelectionAdapter

@Composable
fun DamageCalculatorScreen(
    weapons: ImmutableList<SelectionAdapter>,
    barricades: ImmutableList<SelectionAdapter>,
    selectedWeaponIndex: Int? = null,
    selectedBarricadeIndex: Int? = null,
    onWeaponSelect: (Weapon) -> Unit = {},
    onBarricadeSelect: (Barricade) -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        SelectionButton(item = weapons[0])
        Text("vs")
        SelectionButton(item = barricades[0])
        Spacer(modifier = Modifier.height(20.dp))
    }
}