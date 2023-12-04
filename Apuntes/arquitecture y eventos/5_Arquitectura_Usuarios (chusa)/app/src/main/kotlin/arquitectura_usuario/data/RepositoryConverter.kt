package arquitectura_usuario.data

import arquitectura_usuario.data.mocks.UsuarioMock
import arquitectura_usuario.ui.features.usuario.UsuarioUiState
import com.example.ejemploarquitectura.models.Usuario

//region UsuarioMock
fun UsuarioMock.toUsuario(): Usuario = Usuario(this.login, this.password)
fun MutableList<UsuarioMock>.toUsuarios(): List<Usuario> =
    this.map { it.toUsuario() }
//endregion

//region Usuario
fun Usuario.toUsuarioMock(): UsuarioMock = UsuarioMock(this.login, this.password)
fun Usuario.toUsuarioUiState(logeado: Boolean) =
    UsuarioUiState(this.login, this.password, logeado)
//endregion

//region UsuarioUiState
fun UsuarioUiState.toUsuario() = Usuario(this.login, this.password)
//endregion


