package ru.versoit.presentation.ui

import androidx.compose.runtime.Composable
import ru.versoit.presentation.calculationresults.CloseCombatCalculationResult
import ru.versoit.presentation.calculationresults.GunDamageCalculationResult

interface ViewCalculationResultVisitor {

    @Composable
    fun Visit(damageCalculationResult: GunDamageCalculationResult)

    @Composable
    fun Visit(closeCombatCalculationResult: CloseCombatCalculationResult)
}