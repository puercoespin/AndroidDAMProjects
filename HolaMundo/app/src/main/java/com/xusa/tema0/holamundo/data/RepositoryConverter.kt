package com.xusa.tema0.holamundo.data

import com.xusa.tema0.holamundo.data.mocks.contacto.ContactoMock
import com.xusa.tema0.holamundo.models.Contacto
import java.util.EnumSet

fun ContactoMock.toContacto():Contacto
{

    return Contacto(id=this.id, nombre, apellidos, foto,
        correo, telefono, EnumSet.copyOf(categorias.map { it.toContactoCategoria() }))
}
fun ContactoMock.Categorias.toContactoCategoria():Contacto.Categorias{
   return Contacto.Categorias.values()[this.ordinal]
}
fun Contacto.Categorias.toContactoMockCategoria():ContactoMock.Categorias{
    return ContactoMock.Categorias.values()[this.ordinal]
}

fun Contacto.toContactoMock():ContactoMock{
    return ContactoMock(id=this.id, nombre, apellidos, foto,
        correo, telefono,EnumSet.copyOf(categorias.map { it.toContactoMockCategoria() }))
}