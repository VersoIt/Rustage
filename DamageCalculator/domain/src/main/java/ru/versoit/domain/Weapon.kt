package ru.versoit.domain

interface Weapon {
    val name: String
    val imagePath: String
    val delay: Int   // delay between hits
    val damage: Int  // damage per one hit
    val health: Int  // amount of hits before break

    fun visitShowman(weaponAcceptor: WeaponAcceptVisitor)
}