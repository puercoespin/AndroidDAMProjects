package com.pmdm.login.data

import  com.pmdm.login.data.mocks.usuario.UsuarioMock
import com.pmdm.login.ui.features.login.LoginUiState
import com.pmdm.login.models.Usuario

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






