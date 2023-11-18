package com.login_v3_4.data.mocks.usuario

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