package com.AGENDABASE.data

import com.AGENDABASE.data.mocks.contacto.ContactoMock
import com.AGENDABASE.models.Contacto
import com.AGENDABASE.ui.features.vercontactos.CatergoriaUiState
import com.AGENDABASE.ui.features.vercontactos.toEnum
import java.util.EnumSet


fun ContactoMock.toContacto(): Contacto {
    val categoriasSet = CatergoriaUiState()

    return Contacto(id, nombre, apellidos, foto, correo, telefono, categoriasSet.toEnum())
}

fun ContactoMock.Categorias.toContactoCategoria():Contacto.Categorias{
    return Contacto.Categorias.values()[this.ordinal]
}
fun Contacto.Categorias.toContactoMockCategoria():ContactoMock.Categorias{
    return ContactoMock.Categorias.values()[this.ordinal]
}

fun Contacto.toContactoMock():ContactoMock{
    return ContactoMock(id=this.id, nombre, apellidos, foto,
        correo, telefono, EnumSet.copyOf(categorias.map { it.toContactoMockCategoria() }))
}