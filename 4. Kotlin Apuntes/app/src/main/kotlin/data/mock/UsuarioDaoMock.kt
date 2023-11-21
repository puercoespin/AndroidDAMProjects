package data.mock

class UsuarioDaoMock {
    private val usuarios = mutableListOf<UsuarioMock>()

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