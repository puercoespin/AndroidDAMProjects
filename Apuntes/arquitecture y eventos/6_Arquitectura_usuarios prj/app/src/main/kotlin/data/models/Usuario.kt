package data.models

import data.mock.UsuarioDaoMock

data class Usuario(var login: String, var password: String)
{
    override fun toString(): String {
        return "login: $login password: $password"
    }
}


