package com.pmdm.login.data

import com.pmdm.login.data.mocks.usuario.UsuarioDaoMock

import com.pmdm.login.models.Usuario


class UsuarioRepository {
    val proveedorUsuarios= UsuarioDaoMock()

    fun get():List<Usuario> = proveedorUsuarios.get().toUsuarios()
    fun get(login:String): Usuario?= proveedorUsuarios.get(login)?.toUsuario()
    fun insert(usuario: Usuario)= proveedorUsuarios.insert(usuario.toUsuarioMock())
}