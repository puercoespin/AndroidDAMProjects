package com.AGENDABASE.data

import com.AGENDABASE.data.mocks.contacto.ContactoMock
import com.AGENDABASE.models.Contacto
import com.AGENDABASE.ui.features.vercontactos.CatergoriaUiState
import com.AGENDABASE.ui.features.vercontactos.toEnum
import java.util.EnumSet


fun ContactoMock.toContacto() = Contacto(
    id = id,
    nombre = nombre,
    apellidos = apellidos,
    foto = foto,
    correo = correo,
    telefono = telefono,
    categorias = EnumSet.noneOf(Contacto.Categorias::class.java).apply {
        categorias.forEach { add(it.toCategorias()) }
    }
)

fun Contacto.toContactoMock() = Contacto(
    id = id,
    nombre = nombre,
    apellidos = apellidos,
    foto = foto,
    correo = correo,
    telefono = telefono,
    categorias = EnumSet.noneOf(Contacto.Categorias::class.java).apply {
        categorias.forEach { add(it.toCategorias()) }
    }
)

fun ContactoMock.Categorias.toContactoCategoria():Contacto.Categorias{
    return Contacto.Categorias.values()[this.ordinal]
}
fun Contacto.Categorias.toContactoMockCategoria():ContactoMock.Categorias{
    return ContactoMock.Categorias.values()[this.ordinal]
}



fun ContactoMock.Categorias.toCategorias() = when (this) {
    ContactoMock.Categorias.Amigos -> Contacto.Categorias.Amigos
    ContactoMock.Categorias.Trabajo -> Contacto.Categorias.Trabajo
    ContactoMock.Categorias.Familia -> Contacto.Categorias.Familia
    ContactoMock.Categorias.Emergencias -> Contacto.Categorias.Emergencias
}

