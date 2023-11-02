package ru.versoit.presentation.calculationresults

import androidx.compose.runtime.Composable
import ru.versoit.presentation.adapters.DamageCalculationResult
import ru.versoit.presentation.ui.ViewCalculationResultVisitor

data class GunDamageCalculationResult(val patronsAmount: Int, val seconds: Int) :
    DamageCalculationResult {

    @Composable
    override fun Accept(viewVisitor: ViewCalculationResultVisitor) {
        viewVisitor.Visit(this)
    }
}