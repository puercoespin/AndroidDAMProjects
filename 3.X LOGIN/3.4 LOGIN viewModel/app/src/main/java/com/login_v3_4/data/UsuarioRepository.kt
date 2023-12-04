package com.login_v3_4.data

import com.login_v3_4.data.mocks.usuario.UsuarioDaoMock
import com.login_v3_4.model.Usuario


/*
    Usuario Repository es la base de datos de la aplicación en sí, donde usaremos los métodos
        de conversión para obtener objetos en memoria de nuestra DB (en este caso falsa)
 */


class UsuarioRepository {

    private val usuarioDaoMock: UsuarioDaoMock = UsuarioDaoMock()

    fun get(): MutableList<Usuario> {

        return usuarioDaoMock.get().map { it.toUsuario() }.toMutableList()
    }

    fun get(login: String): Usuario? {
        return get().find { it.login == login }
    }
    fun existingUser(login: String,password:String) : Boolean
    {
        val loginExistente = get(login)
        return loginExistente != null && loginExistente.password == password
    }
    fun insert(usuarioRemoto: Usuario) {
        usuarioDaoMock.insert(usuarioRemoto.toUsuarioMock())
    }

    fun update(usuarioRemoto: Usuario) {
        val existingUser = get(usuarioRemoto.login)
        if (existingUser != null) {
            existingUser.password = usuarioRemoto.password
        }
    }

    fun delete(login: String) {
        get().removeIf { it.login == login }
    }


}