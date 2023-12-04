package arquitectura_usuario.data.mocks


class UsuarioDaoMock {
    private var usuarios = mutableListOf<UsuarioMock>(
        UsuarioMock("juanjo", "juanjo1234"),
        UsuarioMock("pepe", "pepe1234"),
        UsuarioMock("xusa", "xusa1234")
    )

    fun get(): MutableList<UsuarioMock> = usuarios
    fun get(login: String): UsuarioMock? = usuarios.find { u -> u.login == login }
    fun insert(usuarioRemoto: UsuarioMock) = usuarios.add(usuarioRemoto)
    fun update(usuarioRemoto: UsuarioMock) {
        val posicion = usuarios.indexOf(get(usuarioRemoto.login))
        if (posicion != -1) usuarios.removeAt(posicion)
        usuarios.add(usuarioRemoto)
    }

    fun delete(login: String) = usuarios.removeAll { u -> u.login == login }
}
