package data

import data.mock.RecetaMock
import data.mock.UsuarioMock
import data.models.Receta
import data.models.Usuario

fun Usuario.toUsuarioMock() : UsuarioMock
{
    return UsuarioMock(login,password)
}

fun UsuarioMock.toUsuario() : Usuario
{
    return Usuario(login,password)
}


fun Receta.toRecetaMock() : RecetaMock
{
    return RecetaMock(id, cookingTime, recipeName, recipePicture, chefName, chefMail, chefPicture)
}

fun RecetaMock.toReceta() : Receta
{
    return Receta(id, cookingTime, recipeName, recipePicture, chefName, chefMail, chefPicture)
}