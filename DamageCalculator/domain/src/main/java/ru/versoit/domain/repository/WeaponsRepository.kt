package ru.versoit.domain.repository

import ru.versoit.domain.models.Weapon

interface WeaponsRepository {

    suspend fun fetch(): List<Weapon>
}