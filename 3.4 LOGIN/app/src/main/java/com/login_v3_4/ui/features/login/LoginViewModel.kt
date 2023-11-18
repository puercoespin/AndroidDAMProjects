package com.login_v3_4.ui.features.login

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.login_v3_4.data.UsuarioRepository
import com.login_v3_4.utilities.validacion.Validacion

class LoginViewModel : ViewModel(){

    val usuarioRepository : UsuarioRepository = UsuarioRepository()
    var loginUiState : LoginUiState? = null

    // pasamos los stateful de loginScreen aqui
    var emailState by mutableStateOf("")
    var passwordState by mutableStateOf("")
    var validacionEmailState by mutableStateOf(Validacion("", false))
    var validacionPasswordState by mutableStateOf(Validacion("", false))
    var checkboxValue by mutableStateOf(false)
    var hayErrores by mutableStateOf(false)
    var errorMensaje by mutableStateOf("")

    fun onLoginEvent(loginEvent : LoginEvent)
    {
        // los estados de validación cambiarán dependiendo de si el email o la pass son erroneas
        validacionEmailState.hayError = !Patterns.EMAIL_ADDRESS.matcher(emailState).matches()
        validacionPasswordState.hayError = passwordState.length < 8
        // si hay algún error de cualquier tipo, lo ponemos a true
        hayErrores = validacionEmailState.hayError || validacionPasswordState.hayError




        when(loginEvent)
        {
            is LoginEvent.LoginChanged ->{
                // aquí controlamos el evento del textfield cambiado
                // cambiremos el texto del textField y validaremos

                emailState = loginEvent.cadena
                validacionEmailState.hayError = !Patterns.EMAIL_ADDRESS.matcher(emailState).matches()
                validacionEmailState.mensajeError = "El email no cumple los requisitos"

            }
            is LoginEvent.PasswordChanged -> {
                // aquí controlamos el evento del textfield cambiado

                passwordState = loginEvent.cadena
                validacionPasswordState.hayError = passwordState.length < 6
                validacionPasswordState.mensajeError = "La contraseña debe tener más de 6 dígitos"

            }
            is LoginEvent.OnClickLoguearse -> {
                // aquí controlamos el caso de click al botón
                if(!hayErrores)
                {
                    if(usuarioRepository.existingUser(emailState,passwordState))
                    {
                        loginUiState = LoginUiState(emailState,passwordState,true)

                        ///
                        // Codigo a continuación de prueba (Borrar)
                        ///
                        hayErrores = true
                        errorMensaje = "Usuario: $loginUiState"
                    }
                    else{
                        errorMensaje = "Credenciales erroneas"
                        loginUiState = null
                    }
                }
                else{
                    errorMensaje="El email o contraseña no cumplen los requisitos!"
                }
            }
        }
    }

    fun onCheckboxChanged(checked: Boolean) {
        checkboxValue = checked
    }

}