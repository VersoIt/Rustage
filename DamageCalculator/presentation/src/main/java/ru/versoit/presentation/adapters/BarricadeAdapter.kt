package ru.versoit.presentation.adapters

import ru.versoit.domain.Barricade

class BarricadeAdapter(
    barricade: Barricade,
) : SelectionAdapter {
    override val image: String = barricade.image
    override val name: String = barricade.name
}