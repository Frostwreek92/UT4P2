package com.example.ut4p2.data

import com.example.ut4p2.R

object ContactRepository {
    val contactGroups = listOf(
        ContactGroup(
            title = "Departamento Informática",
            contacts = listOf(
                Contact("Jefe de Departamento", R.drawable.ic_profile),
                Contact("Tutora DAM", R.drawable.ic_profile),
                Contact("Tutor DAW", R.drawable.ic_profile),
                Contact("Tutora ASIX", R.drawable.ic_profile)
            )
        ),
        ContactGroup(
            title = "Comunidad Propietarios",
            contacts = listOf(
                Contact("Presidenta", R.drawable.ic_profile),
                Contact("Secretaria", R.drawable.ic_profile),
                Contact("Administrador", R.drawable.ic_profile)
            )
        ),
        ContactGroup(
            title = "Gimnasio",
            contacts = listOf(
                Contact("Entrenadora", R.drawable.ic_profile),
                Contact("Nutricionista", R.drawable.ic_profile),
                Contact("Fisioterapeuta", R.drawable.ic_profile)
            )
        )
    )
}