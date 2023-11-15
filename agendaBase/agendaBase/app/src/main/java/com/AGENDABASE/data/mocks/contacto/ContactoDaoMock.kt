package com.AGENDABASE.data.mocks.contacto

class ContactoDaoMock {

    private var contactos= mutableListOf<ContactoMock>()

    // Obtiene una lista de contactos
    fun get(): MutableList<ContactoMock> = contactos
    // Obtiene un contacto por Id
    fun get(id: Int): ContactoMock? = contactos.find { u -> u.id == id }
    // Inserta un contacto en la colección de contactos
    fun insert(contacto: ContactoMock) = contactos.add(contacto)

}