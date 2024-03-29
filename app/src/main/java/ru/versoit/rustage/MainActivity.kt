package ru.versoit.rustage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import kotlinx.collections.immutable.persistentListOf
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
                                icon = painterResource(id = R.drawable.home)
                            ),
                            NavigationItem(
                                destination = Destination.DAMAGE_CALCULATOR,
                                name = stringResource(id = R.string.damage_calculator),
                                badgeCount = null,
                                hasMessage = false,
                                icon = painterResource(id = R.drawable.calculator)
                            ),
                            NavigationItem(
                                destination = Destination.BINDS,
                                name = stringResource(id = R.string.binds),
                                badgeCount = null,
                                hasMessage = false,
                                icon = painterResource(id = R.drawable.keyboard)
                            )
                        ),
                        persistentListOf(
                            NavigationItem(
                                destination = Destination.HOME,
                                name = stringResource(id = R.string.home),
                                badgeCount = null,
                                hasMessage = false,
                                icon = painterResource(id = R.drawable.home)
                            ),
                            NavigationItem(
                                destination = Destination.DAMAGE_CALCULATOR,
                                name = stringResource(id = R.string.damage_calculator),
                                badgeCount = null,
                                hasMessage = false,
                                icon = painterResource(id = R.drawable.calculator)
                            ),
                            NavigationItem(
                                destination = Destination.BINDS,
                                name = stringResource(id = R.string.binds),
                                badgeCount = null,
                                hasMessage = false,
                                icon = painterResource(id = R.drawable.keyboard)
                            )
                        )
                    )
                }
            }
        }
    }
}