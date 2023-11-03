package ru.versoit.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.collections.immutable.ImmutableList
import ru.versoit.domain.models.Barricade
import ru.versoit.domain.models.Weapon
import ru.versoit.presentation.R
import ru.versoit.presentation.adapters.SelectionAdapter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DamageCalculatorScreen(
    weapons: ImmutableList<SelectionAdapter>,
    barricades: ImmutableList<SelectionAdapter>,
    selectedWeaponIndex: Int? = null,
    selectedBarricadeIndex: Int? = null,
    onWeaponSelect: (Weapon) -> Unit = {},
    onBarricadeSelect: (Barricade) -> Unit = {}
) {
    var isOpenedWeaponSelection by rememberSaveable {
        mutableStateOf(false)
    }
    var isOpenedBarricadeSelection by rememberSaveable {
        mutableStateOf(false)
    }

    BottomSheetSelection(
        isOpen = isOpenedWeaponSelection,
        onDismissRequest = { isOpenedWeaponSelection = false },
        items = weapons
    )
    BottomSheetSelection(
        isOpen = isOpenedBarricadeSelection,
        onDismissRequest = { isOpenedBarricadeSelection = false },
        items = barricades
    )

    Column {
        Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
            Card(
                modifier = Modifier
                    .padding(horizontal = 14.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp, horizontal = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    SelectionButton(
                        modifier = Modifier.fillMaxWidth(),
                        item = weapons[0],
                        onClick = {
                            isOpenedWeaponSelection = true
                        })
                    Text(stringResource(id = R.string.against), fontSize = 20.sp)
                    SelectionButton(
                        modifier = Modifier.fillMaxWidth(),
                        item = barricades[0],
                        onClick = {
                            isOpenedBarricadeSelection = true
                        })
                    Spacer(
                        modifier = Modifier
                            .height(30.dp)
                            .fillMaxWidth()
                    )
                    Button(
                        enabled = false,
                        onClick = {
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            disabledContainerColor = MaterialTheme.colorScheme.primary.copy(
                                alpha = 0.2f
                            )
                        )
                    ) {
                        Text(
                            text = stringResource(id = R.string.calculate).uppercase(),
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }
    }
}