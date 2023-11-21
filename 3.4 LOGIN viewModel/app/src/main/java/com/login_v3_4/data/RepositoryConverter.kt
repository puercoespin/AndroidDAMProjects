package com.login_v3_4.data

import com.login_v3_4.data.mocks.usuario.UsuarioMock
import com.login_v3_4.model.Usuario

/*

    RepositoryConverter, nos pasará de nuestra base de datos (en este caso falsa) a memoria con
            objetos ya reales, en este caso Usuarios
 */

fun Usuario.toUsuarioMock() : UsuarioMock
{
    return UsuarioMock(login,password)
}

fun UsuarioMock.toUsuario() : Usuario
{
    return Usuario(login,password)
}