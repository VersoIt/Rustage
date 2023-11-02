package ru.versoit.rustage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import kotlinx.collections.immutable.persistentListOf
import ru.versoit.domain.Barricade
import ru.versoit.domain.Gun
import ru.versoit.presentation.adapters.BarricadeAdapter
import ru.versoit.presentation.adapters.WeaponAdapter
import ru.versoit.rustage.components.Destination
import ru.versoit.rustage.components.MainScreen
import ru.versoit.rustage.components.NavigationItem
import ru.versoit.rustage.ui.theme.RustageTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RustageTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(
                        persistentListOf(
                            NavigationItem(
                                destination = Destination.HOME,
                                name = stringResource(id = R.string.home),
                                badgeCount = null,
                                hasMessage = false,
                                selectedIcon = Icons.Filled.Home,
                                unselectedIcon = Icons.Outlined.Home,
                            ),
                            NavigationItem(
                                destination = Destination.DAMAGE_CALCULATOR,
                                name = stringResource(id = R.string.damage_calculator),
                                badgeCount = null,
                                hasMessage = false,
                                selectedIcon = Icons.Filled.PlayArrow,
                                unselectedIcon = Icons.Outlined.PlayArrow,
                            ),
                            NavigationItem(
                                destination = Destination.BINDS,
                                name = stringResource(id = R.string.binds),
                                badgeCount = null,
                                hasMessage = false,
                                selectedIcon = Icons.Filled.Create,
                                unselectedIcon = Icons.Outlined.Create,
                            )
                        ),
                        weapons = persistentListOf(
                            WeaponAdapter(
                                Gun(
                                    name = "Assault riffle",
                                    imagePath = "dsf",
                                    delay = 12,
                                    damage = 1,
                                    health = 4,
                                    patrons = 30
                                )
                            )
                        ),
                        barricades = persistentListOf(
                            BarricadeAdapter(
                                Barricade(
                                    name = "Stena",
                                    health = 2,
                                    image = "23"
                                )
                            )
                        )
                    )
                }
            }
        }
    }
}