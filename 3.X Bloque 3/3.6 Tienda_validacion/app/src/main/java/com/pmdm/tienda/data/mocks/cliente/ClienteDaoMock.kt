package com.pmdm.tienda.data.mocks.cliente

import javax.inject.Inject

class ClienteDaoMock @Inject constructor() {

    private var clientes = mutableListOf(
        ClienteMock(
            "11111111K", "juanjo@gmail.com", "Juanjo Perez", "654897584",
            Direccion("Los Molinos, 24Bajo", "Sevilla", "09882"), emptyList<Int>().toMutableList()
        ),
        ClienteMock(
            "22222222L", "pepe@gmail.com", "Pepe Lopez", "145678974",
            Direccion("Los Molinos, 22Bajo", "Sevilla", "09882"), emptyList<Int>().toMutableList()
        ),
        ClienteMock(
            "33333333M", "xusa@gmail.com", "Xusa Rico", "457845698",
            Direccion("Los Molinos, 22Bajo", "Sevilla", "09882"), emptyList<Int>().toMutableList()
        )
    )

    fun get(): MutableList<ClienteMock> = clientes
    fun get(dni:String): ClienteMock? = clientes.find { c-> c.dni==dni }

    fun insert(cliente: ClienteMock) {
        clientes.add(cliente)
    }

    fun delete(cliente: ClienteMock) {
        val c = clientes.find { cliente.dni == it.dni }
        if(c != null) clientes.remove(c)
    }



}