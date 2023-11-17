package com.login_v3_3.ui.features.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.login_v3_3.data.UsuarioRepository

class LoginViewModel : ViewModel(){

    val usuarioRepository : UsuarioRepository = UsuarioRepository()
    var loginUiState : LoginUiState? = null

    // los stateful los tenemos en loginUiState

    fun onLoginEvent(loginEvent : LoginEvent)
    {

        when(loginEvent)
        {
            is LoginEvent.LoginChanged ->{
                // aquí controlamos el evento del textfield cambiado
            }
            is LoginEvent.PasswordChanged -> {
                // aquí controlamos el evento del textfield cambiado
            }
            is LoginEvent.OnClickLoguearse -> {
                // aquí controlamos el caso de click al botón
            }
        }
    }

}