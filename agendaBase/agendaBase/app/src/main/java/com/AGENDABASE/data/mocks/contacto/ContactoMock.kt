package com.AGENDABASE.data.mocks.contacto

import java.util.EnumSet

data class ContactoMock(val id: Int,
                        val nombre: String,
                        val apellidos: String,
                        val foto: String?,
                        val correo: String,
                        val telefono: String,
                        val categorias: EnumSet<ContactoMock.Categorias>)
{
    enum class Categorias {
        Amigos, Trabajo, Familia, Emergencias
    }
}
