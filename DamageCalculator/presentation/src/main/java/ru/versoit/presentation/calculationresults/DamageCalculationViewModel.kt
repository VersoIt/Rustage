package ru.versoit.presentation.calculationresults

import android.util.Log
import androidx.lifecycle.ViewModel
import ru.versoit.domain.Gun
import ru.versoit.domain.Weapon
import ru.versoit.domain.WeaponAcceptVisitor

class DamageCalculationViewModel : ViewModel(), WeaponAcceptVisitor {

    fun onEvent(event: Event) {
        when (event) {
            is Event.Calculate -> event.weapon.visitShowman(this)
        }
    }

    sealed interface Event {
        data class Calculate(val weapon: Weapon) : Event
    }

    override fun acceptWeapon(weapon: Weapon, onAccepted: () -> Unit) {
        Log.e("weapon", "weapon")
    }

    override fun acceptWeapon(gun: Gun, onAccepted: () -> Unit) {
        Log.e("gun", "gun")
    }
}