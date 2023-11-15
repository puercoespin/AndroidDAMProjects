package data

import data.mock.UsuarioMock
import data.models.Usuario

fun Usuario.toUsuarioMock() : UsuarioMock
{
    return UsuarioMock(login,password)
}

fun UsuarioMock.toUsuario() : Usuario
{
    return Usuario(login,password)
}