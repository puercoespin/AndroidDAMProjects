package data

import data.mock.UsuarioDaoMock
import data.mock.UsuarioMock
import data.models.Usuario

class UsuarioRepository() {

    private val usuarioDaoMock : UsuarioDaoMock = UsuarioDaoMock()

    fun get() : MutableList<Usuario>
    {

        return usuarioDaoMock.get().map { it.toUsuario() }.toMutableList()
    }


    fun get(login : String) : Usuario?
    {
        return get().find { it.login == login }
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