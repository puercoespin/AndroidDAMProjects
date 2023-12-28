package com.login_v3_5.ui.features.login

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.login_v3_5.data.UsuarioRepository
import com.login_v3_5.utilities.validacion.Validacion
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LoginViewModel  @Inject constructor(private val usuarioRepository : UsuarioRepository = UsuarioRepository()): ViewModel(){


    var loginUiState : LoginUiState by mutableStateOf(LoginUiState())


    var validacionEmailState by mutableStateOf(Validacion("", false))
    var validacionPasswordState by mutableStateOf(Validacion("", false))

    var hayErrores by mutableStateOf(false)
    var errorMensaje by mutableStateOf("")

    fun onLoginEvent(loginEvent : LoginEvent)
    {
        // los estados de validación cambiarán dependiendo de si el email o la pass son erroneas
        // si hay algún error de cualquier tipo, lo ponemos a true

        when(loginEvent)
        {
            is LoginEvent.LoginChanged ->{
                // aquí controlamos el evento del textfield cambiado
                // cambiremos el texto del textField y validaremos

               loginUiState=loginUiState.copy( login = loginEvent.cadena)
                validacionEmailState.hayError = !Patterns.EMAIL_ADDRESS.matcher(loginEvent.cadena).matches()
                validacionEmailState.mensajeError = "El email no cumple los requisitos"

            }
            is LoginEvent.PasswordChanged -> {
                // aquí controlamos el evento del textfield cambiado

                loginUiState=loginUiState.copy(password = loginEvent.cadena)
                validacionPasswordState.hayError = loginEvent.cadena.length < 6
                validacionPasswordState.mensajeError = "La contraseña debe tener más de 6 dígitos"

            }
            is LoginEvent.onCheckChanged ->{

                loginUiState=loginUiState.copy(recordarPass = loginEvent.checked)

            }
            is LoginEvent.OnClickLoguearse -> {
                // aquí controlamos el caso de click al botón
                if(!hayErrores)
                {
                    if(usuarioRepository.existingUser(login = loginUiState.login,loginUiState.password))
                    {
                        ///
                        // Codigo a continuación de prueba (Borrar)
                        ///
                        hayErrores = true
                        errorMensaje = "Usuario: $loginUiState"
                    }
                    else{
                        errorMensaje = "Credenciales erroneas"
                    }
                }
                else{
                    errorMensaje="El email o contraseña no cumplen los requisitos!"
                }
            }
        }
    }

}