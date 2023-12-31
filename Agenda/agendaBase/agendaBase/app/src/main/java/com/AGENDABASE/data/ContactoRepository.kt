package com.AGENDABASE.data

import com.AGENDABASE.data.mocks.contacto.ContactoDaoMock
import com.AGENDABASE.models.Contacto
import javax.inject.Inject


class ContactoRepository @Inject constructor(
    private var dao : ContactoDaoMock = ContactoDaoMock()
) {

    fun get(): MutableList<Contacto> = dao.get().map { it.toContacto() }.toMutableList()
    fun get(id: Int): Contacto? = dao.get(id)?.toContacto()
    fun insert(contacto: Contacto) = dao.get().add(contacto.toContactoMock())

    fun delete(id: Int)
    {
        get().removeIf{it.id == id}
    }
}