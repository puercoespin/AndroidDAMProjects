package com.pmdm.login.ui.features.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.pmdm.login.data.UsuarioRepository
import com.pmdm.login.models.Usuario
import com.pmdm.login.utilities.validacion.Validacion
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LoginViewModel  @Inject constructor(private  val usuarioRepository: UsuarioRepository) : ViewModel() {

    var usuarioUiState by mutableStateOf(LoginUiState())
        private set
    var validadorLoginUiState by mutableStateOf(ValidadorLoginUiState())
        private set

    fun onLoginEvent(loginEvent: LoginEvent) {
        when (loginEvent) {
            is LoginEvent.LoginChanged -> {
                usuarioUiState = usuarioUiState.copy(
                    login = loginEvent.login
                )
                validadorLoginUiState = validadorLoginUiState.copy(
                    validacionLogin = validaLogin(loginEvent.login)
                )
            }

            is LoginEvent.PasswordChanged -> {
                usuarioUiState = usuarioUiState.copy(
                    password = loginEvent.password
                    )
                validadorLoginUiState = validadorLoginUiState.copy(
                    validacionPassword =validaPassword(loginEvent.password)
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
    
    private fun validaPassword(password:String):Validacion
    {
        if (password.isEmpty()) {
           return Validacion(true, "No puede estar vacío")
        } else if (password.length < 8) {
            return Validacion(true, "El password debe tener como mínimo 8 carácteres")
        } else {
            return Validacion(false)
        }
    }
    
    private fun validaLogin(login:String):Validacion
    {
        if (login.isEmpty()) {
            return Validacion(true, "No puede estar vacío")
        } else if (!Regex("^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})$").matches(login)) {
            return Validacion(true, "Correo no validdo")
        } else {
            return Validacion(false)
        }
    }

    fun ValidadorLoginUiState.valida(): ValidadorLoginUiState {
        val validacionLogin = validaLogin(usuarioUiState.login)
        val validacionPassword = validaPassword(usuarioUiState.password)
        val validacionUsuario = if (validacionLogin.hayError || validacionPassword.hayError)
            Validacion(true, "Comprueba los datos")
        else   Validacion(false)
     /*   val validacionLogeado = if (logearse()) Validacion(false) else Validacion(
            true, "Ese usuario no está registrado con ese correo o contraseña"
        )*/
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