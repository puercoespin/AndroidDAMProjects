package com.pmdm.login.ui.features.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.pmdm.login.data.UsuarioRepository
import com.pmdm.login.models.Usuario
import com.pmdm.utilities.validacion.Validacion
import com.pmdm.utilities.validacion.ValidadorCompuesto
import com.pmdm.utilities.validacion.validadores.ValidaCorreo
import com.pmdm.utilities.validacion.validadores.ValidaLongitudMinimaTexto
import com.pmdm.utilities.validacion.validadores.ValidaTextoVacio
import com.pmdm.utilities.validacion.ValidacionCompuesta


class LoginViewModel : ViewModel() {

    val usuarioRepository = UsuarioRepository()
    var usuarioUiState by mutableStateOf(LoginUiState())
        private set
    var validadorLoginUiState by mutableStateOf(ValidadorLoginUiState())
        private set

    var validadorLogin =
        ValidadorCompuesto(ValidaTextoVacio("El login no puede estar vacío"))
            .add(ValidaCorreo("El correo no es válido"))
    var validadorPassword =
        ValidadorCompuesto(ValidaTextoVacio("El password no puede estar vacío"))
            .add(ValidaLongitudMinimaTexto(8, "El password debe tener como mínimo 8 carácteres"))


    fun onLoginEvent(loginEvent: LoginEvent) {

        when (loginEvent) {
            is LoginEvent.LoginChanged -> {
                usuarioUiState = usuarioUiState.copy(
                    login = loginEvent.login
                )
                validadorLoginUiState = validadorLoginUiState.copy(
                    validacionLogin = validadorLogin.valida(loginEvent.login)
                )
            }

            is LoginEvent.PasswordChanged -> {
                usuarioUiState = usuarioUiState.copy(
                    password = loginEvent.password
                    )
                validadorLoginUiState = validadorLoginUiState.copy(
                    validacionPassword =validadorPassword.valida(loginEvent.password)
                )
            }

            is LoginEvent.OnClickLogearse -> {
                validadorLoginUiState = validadorLoginUiState.valida()
                if (!validadorLoginUiState.validacionUsuario.hayError)
                    usuarioUiState = usuarioUiState.copy(
                        estaLogeado = logearse()
                    )
            }
        }
    }
    

    fun ValidadorLoginUiState.valida(): ValidadorLoginUiState {
        val validacionLogin =  validadorLogin.valida(usuarioUiState.login)
        val validacionPassword =validadorPassword.valida(usuarioUiState.password)
        val validacionUsuario = if (ValidacionCompuesta()
                .add(validacionLogin)
                .add(validacionPassword).hayError
        )
            Validacion(true, "Comprueba los datos")
        else
            Validacion(false)

        return validadorLoginUiState.copy(
            validacionLogin = validacionLogin,
            validacionPassword = validacionPassword,
            validacionUsuario = validacionUsuario
        )
    }

    fun logearse(): Boolean {
        val usuario = usuarioUiState.toUsuario()
        usuarioRepository.get().forEach {
            if (usuario.login == it.login && usuario.password == it.password) return true
        }
        return false
    }

    fun LoginUiState.toUsuario() = Usuario(this.login, this.password)
}