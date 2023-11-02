package ru.versoit.presentation.adapters

import ru.versoit.domain.Weapon

class WeaponAdapter(
    weapon: Weapon,
) : SelectionAdapter {
    override val image: String = weapon.imagePath
    override val name: String = weapon.name
}