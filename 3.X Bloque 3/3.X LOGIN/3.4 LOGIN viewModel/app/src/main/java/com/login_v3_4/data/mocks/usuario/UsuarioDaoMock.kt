package com.login_v3_4.data.mocks.usuario

/*
    Tenemos el DaoMock, donde tendremos nuestra "base de datos" junto a métodos accesores de ella
    Es una base de datos falsa, por eso tenemos una clase usuario falsa llamada UsuarioMock
 */

class UsuarioDaoMock {

    val usuarios = mutableListOf<UsuarioMock>(
        UsuarioMock("usuario1@gmail.com","password1"),
        UsuarioMock("usuario2@gmail.com", "password2")
    )


    fun get(): MutableList<UsuarioMock> {
        return usuarios
    }

    fun get(login: String): UsuarioMock? {
        return usuarios.find { it.login == login }
    }

    fun insert(usuarioRemoto: UsuarioMock) {
        usuarios.add(usuarioRemoto)
    }

    fun update(usuarioRemoto: UsuarioMock) {
        val existingUser = get(usuarioRemoto.login)
        if (existingUser != null) {
            existingUser.password = usuarioRemoto.password
        }
    }

    fun delete(login: String) {
        usuarios.removeIf { it.login == login }
    }


}