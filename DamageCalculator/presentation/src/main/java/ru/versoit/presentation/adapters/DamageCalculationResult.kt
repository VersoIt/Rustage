package ru.versoit.presentation.adapters

import androidx.compose.runtime.Composable
import ru.versoit.presentation.ui.ViewCalculationResultVisitor

interface DamageCalculationResult {

    @Composable
    fun Accept(viewVisitor: ViewCalculationResultVisitor)
}