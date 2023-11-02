package ru.versoit.domain

data class Gun(
    override val name: String,
    override val imagePath: String,
    override val delay: Int,
    override val damage: Int,
    override val health: Int,

    val patrons: Int
) : Weapon {

    override fun visitShowman(weaponAcceptor: WeaponAcceptVisitor) {
        weaponAcceptor.acceptWeapon(this)
    }
}