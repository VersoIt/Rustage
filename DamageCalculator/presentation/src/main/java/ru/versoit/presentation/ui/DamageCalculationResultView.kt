package ru.versoit.presentation.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import ru.versoit.presentation.calculationresults.CloseCombatCalculationResult
import ru.versoit.presentation.calculationresults.GunDamageCalculationResult

class DamageCalculationResultView : ViewCalculationResultVisitor {

    @Composable
    override fun Visit(gunDamageCalculationResult: GunDamageCalculationResult) {
        Text(text = "Some text")
    }

    @Composable
    override fun Visit(closeCombatCalculationResult: CloseCombatCalculationResult) {

    }
}