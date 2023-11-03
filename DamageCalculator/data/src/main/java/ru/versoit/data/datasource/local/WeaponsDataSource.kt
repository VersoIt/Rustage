package ru.versoit.data.datasource.local

import ru.versoit.data.entity.WeaponEntity

interface WeaponsDataSource {

    suspend fun fetch(): List<WeaponEntity>
}