package com.login_v3_3.data

import com.login_v3_3.data.mocks.usuario.UsuarioMock
import com.login_v3_3.model.Usuario

fun Usuario.toUsuarioMock() : UsuarioMock
{
    return UsuarioMock(login,password)
}

fun UsuarioMock.toUsuario() : Usuario
{
    return Usuario(login,password)
}