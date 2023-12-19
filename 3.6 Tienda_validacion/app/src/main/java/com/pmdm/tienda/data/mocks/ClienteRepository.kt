package com.pmdm.tienda.data.mocks

import com.pmdm.tienda.data.mocks.cliente.ClienteDaoMock
import javax.inject.Inject

class ClienteRepository  @Inject constructor(
    private val proveedorClientes: ClienteDaoMock)
{
/*
    fun get():List<Cliente> = proveedorClientes.get().toUsuario()
    fun get(dni:String): Cliente?= proveedorClientes.get(dni)?.toCliente()
    fun insert(cliente: Cliente)= proveedorClientes.insert(cliente.toClienteMock())

 */

}