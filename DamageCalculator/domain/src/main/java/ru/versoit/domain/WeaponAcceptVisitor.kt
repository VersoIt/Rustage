package ru.versoit.domain

interface WeaponAcceptVisitor {

    fun acceptWeapon(weapon: Weapon, onAccepted: () -> Unit = { })

    fun acceptWeapon(gun: Gun, onAccepted: () -> Unit = { })
}