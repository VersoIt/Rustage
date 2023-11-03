package ru.versoit.presentation.adapters

import ru.versoit.domain.models.Weapon

class WeaponAdapter(
    weapon: Weapon,
) : SelectionAdapter {
    override val image: String = weapon.imagePath
    override val name: String = weapon.name
}