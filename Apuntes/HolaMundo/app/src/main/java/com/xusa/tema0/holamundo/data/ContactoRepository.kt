package com.xusa.tema0.holamundo.data

import com.xusa.tema0.holamundo.data.mocks.contacto.ContactoDaoMock
import com.xusa.tema0.holamundo.models.Contacto

class ContactoRepository {

    private var dao = ContactoDaoMock()

    fun get(): MutableList<Contacto> = dao.get().map { it.toContacto() }.toMutableList()
    fun get(id: Int): Contacto? = dao.get(id)?.toContacto()
    fun insert(contacto: Contacto) = dao.get().add(contacto.toContactoMock())
}