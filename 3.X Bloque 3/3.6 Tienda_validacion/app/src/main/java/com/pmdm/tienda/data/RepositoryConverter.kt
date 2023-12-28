package com.pmdm.tienda.data

import  com.pmdm.tienda.data.mocks.usuario.UsuarioMock
import com.pmdm.tienda.ui.features.login.LoginUiState
import com.pmdm.tienda.models.Usuario

//region UsuarioMock
fun UsuarioMock.toUsuario(): Usuario = Usuario(this.login, this.password)
fun MutableList<UsuarioMock>.toUsuarios(): List<Usuario> =
    this.map { it.toUsuario() }
//endregion

//region Usuario
fun Usuario.toUsuarioMock(): UsuarioMock = UsuarioMock(this.login, this.password)
fun Usuario.toUsuarioUiState(logeado: Boolean) =
    LoginUiState(this.login, this.password, logeado)
//endregion

//region UsuarioUiState
fun LoginUiState.toUsuario() = Usuario(this.login, this.password)
//endregion






